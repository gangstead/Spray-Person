'use strict';

angular.module('gangstead.SprayPersonApp')

  .controller('MainCtrl', function($scope, $location, version) {

    $scope.$path = $location.path.bind($location);
    $scope.version = version;

  });
