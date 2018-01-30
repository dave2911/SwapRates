<div class="container">
	<div class="col-md-6 col-sm-8 col-xs-12 col-md-offset-4 ">
      <form name="myForm" method="POST" action="loginForm">
         <p><h3>LOGIN HERE</h3></p><br><br> 
          <div class="row">
            <p class="required">Username:</p>
             <input class="col-md-8 col-sm-10 col-lg-6 col-xs-12" type="text" name="username" ng-model="basicForm.firstName" required>
              <p class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
                <span style="color:red" ng-show="myForm.firstName.$dirty && myForm.firstName.$invalid">
                  <span ng-show="myForm.firstName.$error.required">Username is required.
                  </span>
                </span>
              </p>
          </div><br>
          <div class="row">
            <p class="required">Password:</p>
             <input class="col-md-8 col-sm-10 col-lg-6 col-xs-12" type="password" name="password" ng-model="basicForm.password" required>
              <p class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
                <span style="color:red" ng-show="myForm.password.$dirty && myForm.password.$invalid">
                  <span ng-show="myForm.password.$error.required">Password is required.
                  </span>
                </span>
              </p>
          </div><br>
             <div ng-controller="firstCtrl"><br>
              <button ng-click="submitForm()" class="btn btn-danger" ng-disabled="myForm.firstName.$dirty && myForm.firstName.$invalid || 
               myForm.password.$dirty && myForm.password.$invalid">Submit</button>
            </div>
      </form>
     </div>
  </div>