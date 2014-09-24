'use strict';

angular.module('gangstead.SprayPerson', ['ngAnimate', 'ngRoute'])

  .constant('version', 'v0.1.0')

  .config(function($locationProvider, $routeProvider) {

    $locationProvider.html5Mode(false);

    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html'
      })
      .when('/person', {
        templateUrl: 'views/person.html'
      })
      .otherwise({
        redirectTo: '/'
      });

  });
