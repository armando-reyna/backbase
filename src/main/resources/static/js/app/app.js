'use strict'

var demoApp = angular.module('atms', [ 'ui.bootstrap', 'atms.controllers', 'atms.services' ]);
demoApp.constant("CONSTANTS", {
	host : "/backbase/api/v1/",
	getAtms : "atm",
});