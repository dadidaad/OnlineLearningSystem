<%-- 
    Document   : Home
    Created on : Jan 16, 2022, 10:27:18 PM
    Author     : Hoang ngoc Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
          <!-- Link to bootstrap fontawesome and Boxicon -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>">
        <title>Home page</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <div  class="container">
            <jsp:include page="./header.jsp"></jsp:include>
            </div>

            <!--All home section-->
            <div class="allhome">
                <section class="home" id="home">
                    <div class="content">
                        <h3>Welcome to TutorDuo</h3>
                        <p>
                            The core content of the subject helps students to form and develop their communication ability through practicing listening, speaking, reading and writing skills.</p>
                        <a href="#" class="btn">More information</a>
                    </div>
                    <div class="image">
                        <img src="<i:ReadUrlFromContext url="/assets/image/background-title.png"/>"
                </div>
            </section>

            <!--section about us-->
            <section class="about" id="about">

                <div class="container">

                    <div class="row align-items-center">
                        <div class="col-md-6">
                            <img  src="<i:ReadUrlFromContext url="/assets/image/why.jpg"/>" class="w-100" style="width: 50%;margin-top: 40px" alt="">

                        </div>
                        <div class="col-md-6">
                            <h3 class="title">Tutor duo</h3>
                            <p>why do you choose this website </p>
                            <div class="icons-container">
                                <div class="icons">
                                    <i class="fas fa-book-open"></i>
                                    <h3>Approaching to the lessons</h3>
                                </div>
                                <div class="icons">
                                    <i class="fas fa-chalkboard-teacher"></i>
                                    <h3>Hire the suitable teacher</h3>
                                </div>
                                <div class="icons">
                                    <i class="fas fa-school"></i>
                                    <h3>The high quality of subject</h3>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </section>

            <!-- end section about us-->

            <!--section the famous teacher-->


            <section class="review" id="review">

                <h1 class="heading"> THE TOP <span> TEACHER</span> </h1>

                <div class="box-container">

                    <div class="box">
                        <img src="<i:ReadUrlFromContext url="/assets/image/Maths.png"/>"  alt="">
                        <h3>Mr.Johnatha</h3>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                        </div>
                        <p>How do you introduce teacher</p>
                    </div>
                    <div class="box">
                        <img src="<i:ReadUrlFromContext url="/assets/image/Maths.png"/>" alt="">
                        <h3>john</h3>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                        </div>
                        <p>How do you introduce teacher</p>
                    </div>
                    <div class="box">
                        <img src="<i:ReadUrlFromContext url="/assets/image/Maths.png"/>" alt="">
                        <h3>Miss.Nga</h3>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                        </div>
                        <p>How do you introduce teacher</p>
                    </div>

                </div>
                <a href="#" class="More">Show More</a>
            </section>
            <section class="speciality" id="speciality">

                <!--end section the famous teacher-->              

                <!--section subject-->
                <h1 class="heading"> <span>Subject</span> </h1>

                <div class="box-container">

                    <div class="box">
                        <div class="content">
                            <img src="<i:ReadUrlFromContext url="/assets/image/Mathsicon.png"/>" alt="">
                            <h3>Maths</h3>
                            <p>Mathematics  the science of structure, order, and relation that has evolved from elemental practices of counting, measuring, and describing the shapes of objects.</p>
                        </div>
                    </div>
                    <div class="box">
                        <div class="content">
                            <img src="<i:ReadUrlFromContext url="/assets/image/physic.png"/>" alt="">
                            <h3>Physic</h3>
                            <p>Physics(natural science) is the natural science that studies matter, its fundamental constituents, its motion and behavior through space and time, and the related entities </p>
                        </div>
                    </div>
                    <div class="box">
                        <div class="content">
                            <img src="<i:ReadUrlFromContext url="/assets/image/chemistry.png"/>" alt="">
                            <h3>Chemistry</h3>
                            <p>Chemistry is the study of matter and the chemical reactions between substances. Chemistry is also the study of matter's composition, structure, and properties</p>
                        </div>
                    </div>
                </div>
            </section>
            <!-- end section subject-->

        </div>
        <!--end of home section-->
        <!-- Include footer of web site from general-->
        <div class="container">
            <jsp:include page="./footer.jsp"></jsp:include>
        </div>
    </body>
</html>
