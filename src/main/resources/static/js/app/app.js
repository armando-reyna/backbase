'use strict'

var demoApp = angular.module('atms', [ 'ui.bootstrap', 'atms.controllers', 'atms.services' ]);
demoApp.constant("CONSTANTS", {
	host : "/api/v1/",
	getAtms : "atm",
});