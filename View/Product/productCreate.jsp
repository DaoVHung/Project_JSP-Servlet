<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

    <meta name="author" content="AdminKit">
    <meta name="keywords"
          content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="shortcut icon" href="../../img/icons/icon-48x48.png"/>

    <link rel="canonical" href="https://demo-basic.adminkit.io/"/>

    <title>Create Product</title>

    <link href="css/app2.css" rel="stylesheet">
    <link rel="stylesheet" href="css/2.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>
<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="index.html">
                <span class="align-middle">Gent Steak Management</span>
            </a>

            <ul class="sidebar-nav">
                <li class="sidebar-header">
                    Pages
                </li>
                <li class="sidebar-item ">
                    <a class="sidebar-link" href="index.jsp">
                        <i class="bi bi-house-dash-fill"></i>  <span class="align-middle">Dashboard</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="CatalogServlet">
                        <i class="bi bi-tags"></i>    <span class="align-middle">Category</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="ProductServlet">
                        <i class="bi bi-cup-straw"></i> <span class="align-middle">Product List</span>
                    </a>
                </li>

                <li class="sidebar-item">
                    <a class="sidebar-link" href=BillServlet">
                        <i class="bi bi-receipt"></i> <span class="align-middle">Bill List</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="UserServlet">
                        <i class="bi bi-people-fill"></i><span class="align-middle">User</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="#">
                        <i class="bi bi-phone-vibrate"></i> <span class="align-middle">Contact</span>
                    </a>
                </li>

            </ul>
        </div>
    </nav>

    <div class="main">
        <nav class="navbar navbar-expand navbar-light navbar-bg">
            <a class="sidebar-toggle js-sidebar-toggle mx-2">
                <i class="hamburger align-self-center"></i>
            </a>

        </nav>

        <main class="content">
            <div class="container-fluid p-0">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Creat Product</h3>
                        <nav class="navbar navbar-expand-lg bg-light">
                            <div class="container-fluid">
                                <a class="navbar-brand" href="#">
                                    <button type="button" class="btn btn-success">+ Add new Product</button>
                                </a>
                                <form class="d-flex" role="search">
                                    <input class="form-control me-2 fst-italic" type="search"
                                           placeholder="Enter catalog name... "
                                           aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">Search</button>
                                </form>
                            </div>
                        </nav>
                    </div>



                    <!-- /.card-header -->
                    <div class="card-body">
                        <form action="<%=request.getContextPath()%>/ProductServlet" method="post" enctype="multipart/form-data">
                            <table id="example1" class="table table-bordered table-striped text-center">
                                <tr>
                                    <td colspan="2">
                                        <h3>Nhập thông tin sản phẩm mới !</h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Product Name</td>
                                    <td><input type="text" name="productName"></td>
                                </tr>
                                <tr>
                                    <td>Catalog ID</td>
                                    <td>
                                        <select name="catalogID" id="cataID" class="form-select"  aria-label="Default select example">
                                            <option selected></option>
                                            <c:forEach items="${listcat}" var="c">
                                                <option value="${c.catalogID}"> ${c.catalogName}  </option>
                                            </c:forEach>
                                        </select>
                                  </td>
                                </tr>
                                <tr>
                                    <td>Price</td>
                                    <td><input type="text" name="price"></td>
                                </tr>
                                <tr>
                                    <td>Title</td>
                                    <td><input type="text" name="title"></td>
                                </tr>
                                <tr>
                                    <td>Desciption</td>
                                    <td><textarea name="descriptions" id="descriptions" cols="30" rows="10"></textarea></td>
                                </tr>
                                <tr>
                                    <td>Status</td>
                                    <td>
                                        <input type="radio" name="status" id="active" value="true"/><label for="active">Active</label>
                                        <input type="radio" name="status" id="inactive" value="false"/><label for="inactive">Inactive</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Product Image</td>
                                    <td><input type="file" name="productImg"></td>
                                </tr>
                                <tr>
                                    <td>Sub Image</td>
                                    <td><input type="file" name="subImg" multiple></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input class="btn btn-outline-success"  type="submit" value="Create" name="action">
                                    </td>
                                </tr>

                            </table>
                        </form>
                    </div>
                    <!-- /.card-body -->
                </div>
            </div>
        </main>

        <footer class="footer">
            <div class="container-fluid">
                <div class="row text-muted">
                    <div class="col-6 text-start">
                        <p class="mb-0">
                            <a class="text-muted" href="" target="_blank"><strong>DemoAdminKit</strong></a>
                            - <a class="text-muted" href="" target="_blank"><strong>Bootstrap Admin
                            Template</strong></a> &copy;
                        </p>
                    </div>
                    <div class="col-6 text-end">
                        <ul class="list-inline">
                            <li class="list-inline-item">
                                <a class="text-muted" href="#" target="_blank">Support</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="text-muted" href="#" target="_blank">Help Center</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="text-muted" href="#" target="_blank">Privacy</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="text-muted" href="#" target="_blank">Terms</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="../../js/app.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var ctx = document.getElementById("chartjs-dashboard-line").getContext("2d");
        var gradient = ctx.createLinearGradient(0, 0, 0, 225);
        gradient.addColorStop(0, "rgba(215, 227, 244, 1)");
        gradient.addColorStop(1, "rgba(215, 227, 244, 0)");
        // Line chart
        new Chart(document.getElementById("chartjs-dashboard-line"), {
            type: "line",
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: "Sales ($)",
                    fill: true,
                    backgroundColor: gradient,
                    borderColor: window.theme.primary,
                    data: [
                        2115,
                        1562,
                        1584,
                        1892,
                        1587,
                        1923,
                        2566,
                        2448,
                        2805,
                        3438,
                        2917,
                        3327
                    ]
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                tooltips: {
                    intersect: false
                },
                hover: {
                    intersect: true
                },
                plugins: {
                    filler: {
                        propagate: false
                    }
                },
                scales: {
                    xAxes: [{
                        reverse: true,
                        gridLines: {
                            color: "rgba(0,0,0,0.0)"
                        }
                    }],
                    yAxes: [{
                        ticks: {
                            stepSize: 1000
                        },
                        display: true,
                        borderDash: [3, 3],
                        gridLines: {
                            color: "rgba(0,0,0,0.0)"
                        }
                    }]
                }
            }
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        // Pie chart
        new Chart(document.getElementById("chartjs-dashboard-pie"), {
            type: "pie",
            data: {
                labels: ["Chrome", "Firefox", "IE"],
                datasets: [{
                    data: [4306, 3801, 1689],
                    backgroundColor: [
                        window.theme.primary,
                        window.theme.warning,
                        window.theme.danger
                    ],
                    borderWidth: 5
                }]
            },
            options: {
                responsive: !window.MSInputMethodContext,
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                cutoutPercentage: 75
            }
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        // Bar chart
        new Chart(document.getElementById("chartjs-dashboard-bar"), {
            type: "bar",
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: "This year",
                    backgroundColor: window.theme.primary,
                    borderColor: window.theme.primary,
                    hoverBackgroundColor: window.theme.primary,
                    hoverBorderColor: window.theme.primary,
                    data: [54, 67, 41, 55, 62, 45, 55, 73, 60, 76, 48, 79],
                    barPercentage: .75,
                    categoryPercentage: .5
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                scales: {
                    yAxes: [{
                        gridLines: {
                            display: false
                        },
                        stacked: false,
                        ticks: {
                            stepSize: 20
                        }
                    }],
                    xAxes: [{
                        stacked: false,
                        gridLines: {
                            color: "transparent"
                        }
                    }]
                }
            }
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var markers = [{
            coords: [31.230391, 121.473701],
            name: "Shanghai"
        },
            {
                coords: [28.704060, 77.102493],
                name: "Delhi"
            },
            {
                coords: [6.524379, 3.379206],
                name: "Lagos"
            },
            {
                coords: [35.689487, 139.691711],
                name: "Tokyo"
            },
            {
                coords: [23.129110, 113.264381],
                name: "Guangzhou"
            },
            {
                coords: [40.7127837, -74.0059413],
                name: "New York"
            },
            {
                coords: [34.052235, -118.243683],
                name: "Los Angeles"
            },
            {
                coords: [41.878113, -87.629799],
                name: "Chicago"
            },
            {
                coords: [51.507351, -0.127758],
                name: "London"
            },
            {
                coords: [40.416775, -3.703790],
                name: "Madrid "
            }
        ];
        var map = new jsVectorMap({
            map: "world",
            selector: "#world_map",
            zoomButtons: true,
            markers: markers,
            markerStyle: {
                initial: {
                    r: 9,
                    strokeWidth: 7,
                    stokeOpacity: .4,
                    fill: window.theme.primary
                },
                hover: {
                    fill: window.theme.primary,
                    stroke: window.theme.primary
                }
            },
            zoomOnScroll: false
        });
        window.addEventListener("resize", () => {
            map.updateSize();
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var date = new Date(Date.now() - 5 * 24 * 60 * 60 * 1000);
        var defaultDate = date.getUTCFullYear() + "-" + (date.getUTCMonth() + 1) + "-" + date.getUTCDate();
        document.getElementById("datetimepicker-dashboard").flatpickr({
            inline: true,
            prevArrow: "<span title=\"Previous month\">&laquo;</span>",
            nextArrow: "<span title=\"Next month\">&raquo;</span>",
            defaultDate: defaultDate
        });
    });
</script>
<script>
    CKEDITOR.replace("descriptions");
</script>

</body>

</html>