<%-- 
    Document   : ListSubject
    Created on : Feb 8, 2022, 4:19:04 PM
    Author     : Doan Tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Link to bootstrap fontawesome and Boxicon -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
    crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" 
    integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" 
    crossorigin="anonymous"/>
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

    <!-- Link to css file -->
    <link rel="stylesheet" href="../assets/css/ListSubjectStyle.css">
    <title>TutorDuo</title>
</head>
<body>
    <%@include file="./general/header.jsp" %>
    <!--Side Bar  -->

    <nav class="sidebar close">
        <header>
            <div class="image-text">
                <span class="image">
                    <img src="../assets/image/259151762_463419805435533_5232999905401287810_n.png" alt="">
                </span>

                <div class="text logo-text">
                    <span class="name">TutorDuo</span>
                    <span class="profession">Online Learning</span>
                </div>
            </div>

            <i class='bx bx-chevron-right toggle'></i>
        </header>

        <div class="menu-bar">
            <div class="menu">
                <ul class="menu-links">
                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-table icon' ></i>
                            <span class="text nav-text">Lookup table</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-math icon' ></i>
                            <span class="text nav-text">Subject 1</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-atom icon'></i>
                            <span class="text nav-text">Subject 2</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-test-tube icon' ></i>
                            <span class="text nav-text">Subject 3</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-cube-alt icon' ></i>
                            <span class="text nav-text">Subject 4</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-wallet icon' ></i>
                            <span class="text nav-text">Subject 5</span>
                        </a>
                    </li>

                </ul>
            </div>

            <div class="bottom-content">
                <li class="mode">
                    <div class="sun-moon">
                        <i class='bx bx-moon icon moon'></i>
                        <i class='bx bx-sun icon sun'></i>
                    </div>
                    <span class="mode-text text">Dark mode</span>

                    <div class="toggle-switch">
                        <span class="switch"></span>
                    </div>
                </li>
                
            </div>
        </div>
    </nav>

    <!-- Show case -->
    <section class="bg-dark text-light p-5 text-center text-sm-start showcase">
        <div class="container">
            <div class="d-sm-flex align-items-center justif-content-between">
                <div>
                    <h1>Leaning <span class="text-warning">Important Knowledge</span></h1>
                    <p class="lead my-5">
                        This is where you can learn many knowledge about Math, Physic, Chemistry
                        You can also search important constant, term in high school education program
                        We will summarize the most important knowledge parts of the math, physics, 
                        chemistry in the high school program, these knowledge are the foundation and 
                        they are arranged in the order of the course syllabus, not the division. 
                        Coordinate the current program.
                    </p>
                    <button class="btn btn-primary btn-lg"> <a href="#subject-list"> Start learning </a></button>
                </div>
                <img class="img-fluid w-50 mx-3 d-none d-sm-block" src="../assets/image/istockphoto-1206750602-1024x1024.jpg" alt="">
            </div>
        </div>
    </section>

    <!-- Boxes -->
    <section class="p-5" id="subject-list">
        <div class="container boxes">
            <div class="row text-center">
            <div class="col-md my-3">
                <div class="card bg-dark text-light">
                    <div class="card-body text-center">
                        <i class="far fa-calculator fa-2x"></i>
                    </div>
                    <h3 class="card-title mb-3">Math</h3>
                    <p class="card-text">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                        Non fugiat quae blanditiis numquam iure. Sunt ducimus 
                        nesciunt tempora vitae facere minima repudiandae quidem 
                        fuga a, rerum saepe itaque ad nam!
                    </p>
                    <a href="#" class="btn btn-primary">Read More</a>
                </div>
            </div>
                <div class="col-md my-3">
                    <div class="card bg-secondary text-light">
                        <div class="card-body text-center">
                            <i class="far fa-stopwatch fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">Physics</h3>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                            Non fugiat quae blanditiis numquam iure. Sunt ducimus 
                            nesciunt tempora vitae facere minima repudiandae quidem 
                            fuga a, rerum saepe itaque ad nam!
                        </p>
                        <a href="#" class="btn btn-dark">Read More</a>
                    </div>
                </div>
                <div class="col-md my-3">
                    <div class="card bg-dark text-light">
                        <div class="card-body text-center">
                            <i class="far fa-atom fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">Chemistry</h3>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                            Non fugiat quae blanditiis numquam iure. Sunt ducimus 
                            nesciunt tempora vitae facere minima repudiandae quidem 
                            fuga a, rerum saepe itaque ad nam!
                        </p>
                        <a href="#" class="btn btn-primary">Read More</a>
                    </div>
                </div>

                <div class="col-md my-3">
                    <div class="card bg-secondary text-light">
                        <div class="card-body text-center">
                            <i class="far fa-stopwatch fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">Physics</h3>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                            Non fugiat quae blanditiis numquam iure. Sunt ducimus 
                            nesciunt tempora vitae facere minima repudiandae quidem 
                            fuga a, rerum saepe itaque ad nam!
                        </p>
                        <a href="#" class="btn btn-dark">Read More</a>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </section>

    <section class="p-5">
        <div class="container boxes">
            <div class="row text-center">
            <div class="col-md my-3">
                <div class="card bg-dark text-light">
                    <div class="card-body text-center">
                        <i class="far fa-calculator fa-2x"></i>
                    </div>
                    <h3 class="card-title mb-3">Math</h3>
                    <p class="card-text">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                        Non fugiat quae blanditiis numquam iure. Sunt ducimus 
                        nesciunt tempora vitae facere minima repudiandae quidem 
                        fuga a, rerum saepe itaque ad nam!
                    </p>
                    <a href="#" class="btn btn-primary">Read More</a>
                </div>
            </div>
                <div class="col-md my-3">
                    <div class="card bg-secondary text-light">
                        <div class="card-body text-center">
                            <i class="far fa-stopwatch fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">Physics</h3>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                            Non fugiat quae blanditiis numquam iure. Sunt ducimus 
                            nesciunt tempora vitae facere minima repudiandae quidem 
                            fuga a, rerum saepe itaque ad nam!
                        </p>
                        <a href="#" class="btn btn-dark">Read More</a>
                    </div>
                </div>
                <div class="col-md my-3">
                    <div class="card bg-dark text-light">
                        <div class="card-body text-center">
                            <i class="far fa-atom fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">Chemistry</h3>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                            Non fugiat quae blanditiis numquam iure. Sunt ducimus 
                            nesciunt tempora vitae facere minima repudiandae quidem 
                            fuga a, rerum saepe itaque ad nam!
                        </p>
                        <a href="#" class="btn btn-primary">Read More</a>
                    </div>
                </div>

                <div class="col-md my-3">
                    <div class="card bg-secondary text-light">
                        <div class="card-body text-center">
                            <i class="far fa-stopwatch fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">Physics</h3>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                            Non fugiat quae blanditiis numquam iure. Sunt ducimus 
                            nesciunt tempora vitae facere minima repudiandae quidem 
                            fuga a, rerum saepe itaque ad nam!
                        </p>
                        <a href="#" class="btn btn-dark">Read More</a>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </section>
    
    <%@include file="./general/footer.jsp" %>
    <!-- link to java script file -->
    <script src="../assets/js/ListSubjectScript.js"></script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
crossorigin="anonymous"></script>
</html>
