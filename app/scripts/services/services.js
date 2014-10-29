'use strict';

angular.module('gangstead.SprayPerson')
<<<<<<< HEAD
  .factory('GetPeople', function($resource){
    return $resource('api/person', {})
=======
  .factory('People', function($resource){
    return $resource('api/person/:id', { id: '@id'}, {
      update: {
        method: 'PUT'
      }
    });
>>>>>>> credera/master
  });
