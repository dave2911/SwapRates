package com.jwt.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Rates;
import com.jwt.model.User;
import com.jwt.service.RatesService;
import com.jwt.service.UserService;

@Controller
public class SwapRateController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RatesService ratesService;

	
	@RequestMapping(value="/")
	public ModelAndView index(HttpServletRequest httpServletRequest)
	{
		if(httpServletRequest.getSession().getAttribute("loggedIn")!=null)
		{	
			return new ModelAndView("current");
		}
		else
			return new ModelAndView("index");
	}
	
	@RequestMapping(value="/index")
	public ModelAndView index1(HttpServletRequest httpServletRequest)
	{
		if(httpServletRequest.getSession().getAttribute("loggedIn")!=null)
		{	
			return new ModelAndView("current");
		}
		else
			return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/loginForm")
	public ModelAndView loginModule(HttpServletRequest httpServletRequest)
	{
		String firstName=httpServletRequest.getParameter("username");
		String password=httpServletRequest.getParameter("password");
		User usr=userService.getUser(firstName);
		if(usr!=null){
			if(usr.getPassword().equals(password) && usr.getUsername().equals(firstName))
			{
				System.out.println(usr.getUser_id()+" "+usr.getRole()+" "+usr.getPassword()+" "+usr.getUsername());
				httpServletRequest.getSession().setAttribute("loggedIn", "true");
				return new ModelAndView("update");
			}
			else
			{
				return new ModelAndView("index","error","incorrect username password");
			}
		}
		else
		{
			return new ModelAndView("index","error","incorrect username password");
		}

	}


	@RequestMapping("/update")
	public ModelAndView update(){
		return new ModelAndView("update");
	}
	
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	public ModelAndView uploadFile(@RequestParam CommonsMultipartFile file,HttpSession httpSession) throws IOException
	{
		String path=httpSession.getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		try
		{
			byte data[]=file.getBytes();
			BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(path+"/"+filename));
			bufferedOutputStream.write(data);
			System.out.println(data);
			bufferedOutputStream.close();
		}
		catch(Exception e){}
		
		System.out.println(path+""+filename);
		FileReader fileReader=new FileReader(new File(path+""+filename));
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		String header_line[]=bufferedReader.readLine().split(",");
		String line="";
		List<Rates> allrates=new ArrayList<>();
		int id=21;
		while((line=bufferedReader.readLine())!=null)
		{
			System.out.println("line1"+line);
			String lines[]=line.split(",");
			Rates rate=new Rates();
			java.sql.Date dt=java.sql.Date.valueOf(lines[0]);
			rate.setDate(dt);
			rate.setSwap_rate_id(id++);
			rate.setInr(Float.parseFloat(lines[1]));
			rate.setCad(Float.parseFloat(lines[2]));
			rate.setAus(Float.parseFloat(lines[3]));
			rate.setEur(Float.parseFloat(lines[4]));
			rate.setLast_updated(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			//allrates.add(rate);
			ratesService.addRates(rate);
		}
		
		return new ModelAndView("display");
	}
	
	@RequestMapping("/display")
	public ModelAndView displayData()
	{
		ModelAndView modelAndView=new ModelAndView("display");
		List<Rates> allRates=ratesService.getAllRates();
		modelAndView.addObject("allrates",allRates);
		return modelAndView;
	}
	
	@RequestMapping(value="/singleUpdate")
	public ModelAndView updateDateData(HttpServletRequest httpServletRequest)
	{	
		ModelAndView modelAndView=new ModelAndView("update");
		java.sql.Date dt=java.sql.Date.valueOf(httpServletRequest.getParameter("dt"));
		System.out.println(httpServletRequest.getParameter("dt"));
		Rates rt=ratesService.getRates(dt);
		modelAndView.addObject("rates",rt);
		modelAndView.addObject("date",dt);
		return modelAndView;
	}
	
	@RequestMapping(value="/rateUpdate")
	public ModelAndView updateOrAdd(HttpServletRequest httpServletRequest,HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView("display");
		int id=0;
		if(Integer.parseInt(httpServletRequest.getParameter("id"))>0)
			id=Integer.parseInt(httpServletRequest.getParameter("id"));
		else
			id=(int)(Math.random()*9999+1);
		
		System.out.println("ID"+id);
		System.out.println("update value happening");
		float inr=Float.parseFloat(httpServletRequest.getParameter("inr"));
		float eur=Float.parseFloat(httpServletRequest.getParameter("eur"));
		float cad=Float.parseFloat(httpServletRequest.getParameter("cad"));
		float aus=Float.parseFloat(httpServletRequest.getParameter("aus"));
		java.sql.Date dt=java.sql.Date.valueOf(httpServletRequest.getParameter("date"));
		java.sql.Date last_updated_date=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		System.out.println(inr+" "+ eur+""+cad+""+id+""+dt+""+last_updated_date);
		Rates rates=new Rates();
		rates.setSwap_rate_id(id);
		rates.setLast_updated(last_updated_date);
		rates.setDate(dt);
		rates.setInr(inr);rates.setAus(aus);rates.setCad(cad);rates.setEur(eur);
		
		ratesService.addRates(rates);
		List<Rates> allRates=ratesService.getAllRates();
		modelAndView.addObject("allrates",allRates);
		return modelAndView;
	}
	
	@RequestMapping(value="/downlaodFile")
	public ModelAndView downloadFile(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
	{
		httpServletResponse.setContentType("text/csv");
	    httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data.csv\"");
	    try
	    {
	        OutputStream outputStream = httpServletResponse.getOutputStream();
	        String csvData=ratesService.getCSV(ratesService.getAllRates());
	        String outputResult =csvData;
	        outputStream.write(outputResult.getBytes());
	        outputStream.flush();
	        outputStream.close();
	    }
	    catch(Exception e)
	    {
	        System.out.println(e.toString());
	    }
		return new ModelAndView("");
	}
	
	@RequestMapping("/downlaodJsonFile")
	public ModelAndView downloadJSONFile(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
	{
		httpServletResponse.setContentType("text/csv");
	    httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data.json\"");
	    try
	    {
	        OutputStream outputStream = httpServletResponse.getOutputStream();
	        String csvData=ratesService.getJSON(ratesService.getAllRates());
	        String outputResult =csvData;
	        outputStream.write(outputResult.getBytes());
	        outputStream.flush();
	        outputStream.close();
	    }
	    catch(Exception e)
	    {
	        System.out.println(e.toString());
	    }
		return new ModelAndView("");
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logoutUser(HttpServletRequest httpServletRequest)
	{
		httpServletRequest.getSession().invalidate();
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/current")
	public ModelAndView currentSwaprate()
	{
		java.sql.Date today=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		Rates rate=ratesService.getRates(today);
		return new ModelAndView("current","rate",rate);
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register(HttpServletRequest httpServletRequest)
	{
		String username=httpServletRequest.getParameter("username");
		User usr=userService.getUser(username);
		if(usr!=null)
		{
			return new ModelAndView("");
		}
		else
			return new ModelAndView("registration","error","already a user");
	}
	@RequestMapping(value="/registration")
	public ModelAndView registration()
	{
		return new ModelAndView("register");
	}
	
}
