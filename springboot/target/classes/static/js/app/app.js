'use strict'
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
  $http.get("students/4").then(function (response) {
      $scope.myData = response.data;
  });
});