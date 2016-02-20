agGrid.initialiseAgGridWithAngular1(angular);

var app = angular.module('testapp', ["agGrid"]);

app.controller('MonitoringController', ['$scope', '$interval', '$http', function ($scope, $interval, $http) {

    //stub userId
    var userId = 1;

    var types = ['deposit', 'withdrawal', 'transfer'];

    $scope.types = types;

    types.forEach(function(type) {

        var refreshRows = function() {
            $http.get("rest/operation/" + type + "/data/" + userId).success(function(data) {
                var rowData = data.map(function(row) {
                    return row.data;
                });

                $scope[gridOptionsName].api.setRowData(rowData);
            });
        };

       var gridOptionsName = type + 'GridOptions';

        $scope[gridOptionsName] = {
            showToolPanel: true,
            toolPanelSuppressGroups: true,
            columnDefs: []
        };

        $http.get("rest/operation/" + type + "/definition")
            .success(function(definitions) {
                var columnDefs = definitions.map(function(definition) {
                    return {
                        headerName: definition,
                        field: definition
                    }
                });

                $scope[gridOptionsName].api.setColumnDefs(columnDefs);

                refreshRows();
                $interval(refreshRows, 5000);
            });
    });
}]);

