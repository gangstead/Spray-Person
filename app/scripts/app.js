'use strict';

angular.module('gangstead.SprayPerson', ['ngAnimate', 'ngRoute','ngResource'])

  .constant('version', 'v0.1.0')

  .config(function($locationProvider, $routeProvider) {

    $locationProvider.html5Mode(false);

    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'MainCtrl'
      })
      .when('/person', {
        templateUrl: 'views/person.html',
        controller: 'PersonCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });

  });
