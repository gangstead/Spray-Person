'use strict';

angular.module('gangstead.SprayPerson')

  .controller('MainCtrl', function($scope, $location, version) {
    $scope.$path = $location.path.bind($location);
    $scope.version = version;
  })
  .controller('PersonCtrl', function($scope, $location, $route, version, People) {
    $scope.$path = $location.path.bind($location);
    $scope.version = version;
    $scope.people = People.query();
    $scope.canEdit = true;
    $scope.canDelete = true;

    $scope.deletePerson=function(person){
      person.$delete(function(){
        $route.reload();
      });
    };
    $scope.editPerson=function(person){
      $location.path('/person/' + person.id + '/edit');
    };

  })
  .controller('PersonViewCtrl', function($scope, $location, $route, $routeParams, version, People) {
    $scope.$path = $location.path.bind($location);
    $scope.person=People.get({id:$routeParams.id});
    $scope.canEdit = true;
    $scope.canDelete = true;

    $scope.deletePerson=function(person){
      person.$delete(function(){
          $location.path('/person');
      });
    };
    $scope.editPerson=function(person){
      $location.path('/person/' + person.id + '/edit');
    };

  })
  .controller('PersonEditCtrl', function($scope, $location, $route, $routeParams, version, People) {
    $scope.$path = $location.path.bind($location);
    $scope.person=People.get({id:$routeParams.id});
    $scope.canEdit = false;
    $scope.canDelete = true;

    $scope.deletePerson=function(person){
      person.$delete(function(){
          $location.path('/person');
      });
    };
    $scope.updatePerson=function(){
      $scope.person.$update(function(){
          $location.path('/person/'+$scope.person.id);
      });
    };
  })
  .controller('PersonNewCtrl', function($scope, $location, $route, $routeParams, version, People) {
    $scope.$path = $location.path.bind($location);
    $scope.person = new People();
    $scope.canEdit = false;
    $scope.canDelete = false;

    function isInt(value) {
      return !isNaN(value) &&
        parseInt(Number(value)) === value &&
        !isNaN(parseInt(value, 10));
    }

    $scope.addPerson=function(){
      if(!isInt($scope.person.age)) $scope.person.age=0;

      $scope.person.$save(function(){
        $location.path('/person');
      });
    };
  });
