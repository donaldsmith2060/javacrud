'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers', 'xeditable',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {
	getUserByIdUrl : "/user/getUser/",
	getAllUsers : "/user/getAllUsers",
	saveUser : "/user/saveUser",
	delUser : "/user/delUser"
});
demoApp.run(['editableOptions', function(editableOptions) {
  editableOptions.theme = 'bs3';
}]);