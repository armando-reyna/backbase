<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Main Page</title>
</head>
<body ng-app="atms">

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Atm's Locator</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="login">Login</a></li>
        <li class="active"><a href="#">Atm's</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container" ng-controller="AtmController">
  <div class="starter-template">
    <h1>ATM's</h1>
  </div>

  <div class="container">

    <div class="row">
      <div class="col-md-6">
        <form class="form-inline">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search for Dutch city..." ng-model="city">
          </div>
          <button type="button" class="btn btn-primary" ng-click="goToPage(0)">Search</button>
          <button type="button" class="btn btn-primary" ng-click="city = ''; goToPage(0)">Clear</button>
        </form>
        <div class="space-md"></div>
        <button type="button" class="btn btn-primary" ng-click="goToPage(page)">Refresh</button>
      </div>
      <div class="col-md-6">
        <div class="row">
          <div class="col-md-12">
            <ul class="pagination justify-content-center pull-right">
              <li class="page-item">
                <a class="page-link" ng-click="goToPage(0)">First</a>
              </li>
              <li class="page-item">
                <a class="page-link" ng-click="goToPage(page-1)">Previous</a>
              </li>
              <li class="page-item">
                <a class="page-link" ng-click="goToPage(page+1)">Next</a>
              </li>
              <li class="page-item">
                <a class="page-link" ng-click="goToPage(data.totalPages-1)">Last</a>
              </li>
            </ul>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <div class="pull-right">Displaying records from {{(data.number*data.size)+1}} to {{(data.number*data.size)+data.numberOfElements}} of {{data.totalElements}}</div>
          </div>
        </div>
      </div>
    </div>

    <div class="space-md"></div>

    <table class="table table-hover">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Street</th>
        <th scope="col">Postal Code</th>
        <th scope="col">City</th>
        <th scope="col">Geolocation</th>
        <th scope="col">Map</th>
      </tr>
      </thead>
      <tbody>
      <tr ng-repeat="atm in data.content">
        <th scope="row"><span ng-bind="$index+(data.number*data.size)+1"></span></th>
        <td>
          <span ng-bind="atm.address.street"></span>
          <span ng-bind="atm.address.housenumber"></span>
        </td>
        <td><span ng-bind="atm.address.postalcode"></span></td>
        <td><span ng-bind="atm.address.city"></span></td>
        <td>
          <span ng-bind="atm.address.geoLocation.lat"></span>,
          <span ng-bind="atm.address.geoLocation.lng"></span>
        </td>
        <td><a target="_blank" href="https://maps.google.com/?q={{atm.address.geoLocation.lat}},{{atm.address.geoLocation.lng}}">See in Maps</a></td>
      </tr>
      </tbody>
    </table>

  </div>

</div>

<script src="js/lib/angular.min.js"></script>
<script src="js/lib/ui-bootstrap-tpls-2.5.0.min.js"></script>
<script src="js/app/app.js"></script>
<script src="js/app/AtmController.js"></script>
<script src="js/app/AtmService.js"></script>
<link rel="stylesheet" href="css/lib/bootstrap.min.css"/>
<link rel="stylesheet" href="css/app/app.css"/>

</body>
</html>