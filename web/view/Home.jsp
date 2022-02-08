<%-- 
    Document   : Home
    Created on : Jan 16, 2022, 10:27:18 PM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<i:ImportUrl url="/assets/css/style.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div  class="container">
            <jsp:include page="./header.jsp"></jsp:include>
        </div>
        <div class="allhome">
        <!--home sections-->
  <section class="home" id="home">
    <div class="content">
        <h3>Welcome to TutorDuo</h3>
        <p>
            The core content of the subject helps students to form and develop their communication ability through practicing listening, speaking, reading and writing skills.</p>
            <a href="#" class="btn">More information</a>
    </div>
    <div class="image">
         <img src="<i:ImportUrl url="/assets/image/background-title.png"/>"
    </div>
</section>

<!--section about us-->
<section class="about" id="about">

    <div class="container">
 
       <div class="row align-items-center">
        <div class="col-md-6">
             <img  src="<i:ImportUrl url="/assets/image/why.jpg"/>" class="w-100" style="width: 50%;margin-top: 40px" alt="">
            
        </div>
        <div class="col-md-6">
             <h3 class="title">Tutor duo</h3>
             <p>Ly do tai sao.</p>
             <a href="#" class="link-btn">read more</a>
             <div class="icons-container">
                <div class="icons">
                   <i class="fas fa-book-open"></i>
                   <h3>Ly do 1</h3>
                </div>
                <div class="icons">
                   <i class="fas fa-chalkboard-teacher"></i>
                   <h3>Ly do 2</h3>
                </div>
                <div class="icons">
                   <i class="fas fa-school"></i>
                   <h3>Ly do 3</h3>
                    </div>
             </div>
          </div>
       </div>
 
    </div>
 
 </section>

<!--section why using-->

<!--section giao vien-->


             <section class="review" id="review">

    <h1 class="heading"> GIẢNG VIÊN <span> TIÊU BIỂU</span> </h1>
   
    <div class="box-container">

        <div class="box">
            <img src="<i:ImportUrl url="/assets/image/Maths.png"/>"  alt="">
            <h3>Thang nao</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
            </div>
            <p>Giới thiệu giáo viên như thế nào</p>
        </div>
        <div class="box">
            <img src="<i:ImportUrl url="/assets/image/Maths.png"/>" alt="">
            <h3>john</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
            </div>
            <p>Giới thiệu giáo viên như thế nào</p>
        </div>
        <div class="box">
            <img src="<i:ImportUrl url="/assets/image/Maths.png"/>" alt="">
            <h3>john</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
            </div>
            <p>Giới thiệu giáo viên như thế nào</p>
        </div>

    </div>
                <a href="#" class="More">Show More</a>
            <section class="speciality" id="speciality">

    <h1 class="heading"> <span>Subject</span> </h1>

    <div class="box-container">

        <div class="box">
            <img class="image" src="<i:ImportUrl url="/assets/image/Maths.png"/>" alt="">
            <div class="content">
                <img src="<i:ImportUrl url="/assets/image/Mathsicon.png"/>" alt="">
                <h3>Maths</h3>
                <p>the study of numbers, shapes, and space using reason and usually a special system of symbols and rules for organizing them</p>
            </div>
        </div>
        <div class="box">
            <img class="image" src="<i:ImportUrl url="/assets/image/Maths.png"/>" alt="">
            <div class="content">
                <img src="<i:ImportUrl url="/assets/image/Mathsicon.png"/>" alt="">
                <h3>Maths</h3>
                <p>the study of numbers, shapes, and space using reason and usually a special system of symbols and rules for organizing them</p>
            </div>
        </div>
        <div class="box">
            <img class="image" src="<i:ImportUrl url="/assets/image/Maths.png"/>" alt="">
            <div class="content">
                <img src="<i:ImportUrl url="/assets/image/Mathsicon.png"/>" alt="">
                <h3>Maths</h3>
                <p>the study of numbers, shapes, and space using reason and usually a special system of symbols and rules for organizing them</p>
            </div>
        </div>
    </div>
</section>
</section>


</section>
        <div class="container">
            <jsp:include page="./footer.jsp"></jsp:include>
        </div>
    </body>
</html>
