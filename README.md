# c_h_g

### 깃허브 사용법을 연습하면서

![라우터](./images/router.jpg)

### 자바와 python을 중점적으로
```javascript
<script>
   angular.module('todo').controller('TodoCtrl', function($scope, todoStorage) {

  $scope.todos = todoStorage.get();

  $scope.remove = function(todo) {
    todoStorage.remove(todo);
  };
  $scope.add = function(newTodoTitle) {
    todoStorage.add(newTodoTitle);
    $scope.newTodoTitle = "";
  };
  
  $scope.update = function(){
    todoStorage.update();
  }
  });
</script>
```
### 학습하고 있습니다.
