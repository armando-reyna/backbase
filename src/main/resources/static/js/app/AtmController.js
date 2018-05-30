'use strict'

var module = angular.module('atms.controllers', []);
module.controller("AtmController", ["$scope", "AtmService",
  function ($scope, AtmService) {

    $scope.page = 0;
    $scope.limit = 20;

    $scope.getAtms = function () {
      AtmService.getAtms($scope.page, $scope.limit, $scope.city).then(function (response) {
        $scope.data = response.data;
      }, function (reason) {
        console.error("Error getting the atm's list." + reason);
      });
    };

    $scope.getAtms();

    $scope.goToPage = function (page) {
      $scope.page = page;
      $scope.getAtms();
    };

  }]);