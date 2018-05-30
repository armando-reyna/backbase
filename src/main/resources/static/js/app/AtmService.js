'use strict'

angular.module('atms.services', []).factory('AtmService',
    ["$http", "CONSTANTS", function ($http, CONSTANTS) {
      var service = {};
      service.getAtms = function (page, limit, city) {
        var url = CONSTANTS.host + CONSTANTS.getAtms + '?page=' + page + '&limit=' + limit;
        if(city){
          url += '&city=' + city;
        }
        return $http.get(url);
      };
      return service;
    }]);