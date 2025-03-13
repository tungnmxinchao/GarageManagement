<%--
    Document   : saleInvoices
    Created on : Mar 13, 2025
    Author     : YourName
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sale Invoices - GARAGE Management</title>
        <meta name="description" content="Sale Invoice Management System">
        <meta name="author" content="YourName">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="style/slider.css">
        <link rel="stylesheet" type="text/css" href="style/mystyle.css">
        <link rel="stylesheet" type="text/css" href="source/custon-css/header-customer.css">

        <style>
            .invoice-container {
                padding: 25px;
                margin: 20px auto;
                max-width: 800px;
                border: 1px solid #e0e0e0;
                border-radius: 8px;
                background-color: #ffffff;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
                transition: all 0.3s ease;
            }

            .invoice-container:hover {
                box-shadow: 0 5px 15px rgba(0,0,0,0.15);
                transform: translateY(-2px);
            }

            .invoice-section {
                margin-bottom: 20px;
                padding: 15px;
                background-color: #f8f9fa;
                border-radius: 5px;
            }

            .invoice-section h3 {
                color: #2c3e50;
                font-size: 1.4em;
                margin-bottom: 15px;
                padding-bottom: 10px;
                border-bottom: 2px solid #3498db;
                font-weight: 600;
            }

            .invoice-section p {
                margin: 8px 0;
                font-size: 1em;
                color: #444;
                line-height: 1.6;
            }

            .invoice-section strong {
                color: #2c3e50;
                font-weight: 600;
                min-width: 130px;
                display: inline-block;
            }

            .invoice-section p:not(:last-child) {
                border-bottom: 1px dashed #eee;
                padding-bottom: 8px;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="common/header.jsp"></jsp:include>

            <div class="allcontain">
                <h1 class="text-center">• SALE INVOICES •</h1>

            <c:choose>
                <c:when test="${empty invoices}">
                    <p class="text-center">No sale invoices found.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${invoices}" var="invoice">
                        <div class="invoice-container">
                            <div class="row">
                                <div class="col-md-12">
                                    <!-- Invoice Information -->
                                    <div class="invoice-section">
                                        <h3>Invoice Information</h3>
                                        <p><strong>Invoice ID:</strong> ${invoice.invoiceID}</p>
                                        <p><strong>Invoice Date:</strong> 
                                            <fmt:formatDate value="${invoice.invoiceDate}" pattern="yyyy-MM-dd"/>
                                        </p>
                                    </div>

                                    <!-- Customer Information -->
                                    <div class="invoice-section">
                                        <h3>Customer Information</h3>
                                        <p><strong>Name:</strong> ${invoice.customer.custName}</p>
                                        <p><strong>Phone:</strong> ${invoice.customer.phone}</p>
                                    </div>

                                    <!-- Car Information -->
                                    <div class="invoice-section">
                                        <h3>Car Information</h3>
                                        <p><strong>Car ID:</strong> ${invoice.car.carId}</p>
                                        <p><strong>Serial Number:</strong> ${invoice.car.serialNumber}</p>
                                        <p><strong>Model:</strong> ${invoice.car.model}</p>
                                        <p><strong>Color:</strong> ${invoice.car.colour}</p>
                                        <p><strong>Year:</strong> ${invoice.car.year}</p>
                                    </div>

                                    <!-- Sales Person Information -->
                                    <div class="invoice-section">
                                        <h3>Sales Person Information</h3>
                                        <p><strong>Name:</strong> ${invoice.salePerson.salesName}</p>
                                        <!-- Add more sales person fields as needed -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>

        <!-- Footer -->
        <jsp:include page="common/footer.jsp"></jsp:include>

        <script type="text/javascript" src="source/js/header-customer.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
        <script type="text/javascript" src="source/js/isotope.js"></script>
        <script type="text/javascript" src="source/js/myscript.js"></script> 
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
    </body>
</html>