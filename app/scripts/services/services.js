'use strict';

angular.module('gangstead.SprayPerson')
  .factory('GetPeople', function($resource){
    return $resource('api/person', {})
  });
