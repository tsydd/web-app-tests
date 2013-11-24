require.config({
    paths: {
        angular: '../lib/angular/angular',
        angularUiRouter: '../lib/angular-ui-router/release/angular-ui-router',
        angularResource: '../lib/angular-resource/angular-resource'
    },
    shim: {
        angular: {exports: 'angular'},
        angularUiRouter: ['angular'],
        angularResource: ['angular']
    },
    priority: [
        'angular'
    ]
});

require(['angular', 'app'], function (angular, app) {
    var $html = angular.element(document.getElementsByTagName('html')[0]);

    angular.element().ready(function () {
        $html.addClass('ng-app');
        angular.bootstrap($html, [app['name']]);
    })
});