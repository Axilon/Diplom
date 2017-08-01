<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auto Master</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>


<div>
    <div class="container">
        <h3><img height="50" width="55" src="<c:url value="/static/logo3.png"/>"/><a href="/admin" > Ложе админа</a></h3>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" >
                    <div class="nav navbar-nav btn-group">

                        <!-- <li><button type="button" id="products_list" class="btn btn-success navbar-btn">Список товаров</button></li> -->

                        <button type="button" id="add_product_type" class="btn btn-success navbar-btn">Добавить категорию</button>
                        <button type="button" id="product_type_list" class="btn btn-success navbar-btn">Список категорий</button>


                    </div>

                    <div  class="nav navbar-nav btn-group navbar-right ">

                        <button type="button" id="users_list" class="btn btn-primary navbar-btn">Список пользователей</button>
                        <button type="button" id="products_list" class="btn btn-primary navbar-btn">Список товаров</button>
                        <button type="button" id="orders_list" class="btn btn-primary navbar-btn">Список заказов</button>
                        <button type="button" id="go_index" class="btn btn-primary navbar-btn" >На главную</button>
                    </div>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>


            <div class="container">
                <form role="form" action="/admin/product_type/${productType_id}/update" method="post" >
                    <h3>Изменение данных категории</h3>
                    Название:<br>
                    <input class="form-control form-group" type="text" name="name" value="${productTypeName}" ><br>
                    <input type="submit" value="Обновить данные">
                </form>
                <br>

                <form role="form" action="/admin/product_type/photo/${productType_id}/update" method="post" enctype="multipart/form-data">
                    <fieldset >
                        Изображение: <br>
                        <img src="/admin/product_type/photo/${productType_id}" type="file" height="100px" width="100px"><br>
                        <input class="form-control form-group" type="file" name="picture"><br>
                        <input type="submit" value="Обновить изображение">
                    </fieldset>
                </form>
            </div>




        <br><br>
        <c:url value="/logout" var="logoutUrl" />
        <p align="right">Click to logout: <a href="${logoutUrl}">LOGOUT</a></p>
    </div>

    <script src="<c:url value="/static/js/admin.js"/> "></script>

</div>
</body>
</html>