<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Service</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" type="text/css" href="source/custon-css/dashboard-custom.css">
    </head>
    <body>
        <jsp:include page="common/side-bar-dashboard.jsp"></jsp:include>

            <!-- Main Content -->
            <div class="content">
                <h2>Edit Service</h2>

                <!-- Edit Service Form -->
                <form action="editService" method="post">
                    <input type="hidden" name="serviceId" value="${service.serviceID}">
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="serviceName" class="form-label">Service Name</label>
                        <input type="text" class="form-control" id="serviceName" name="serviceName" 
                               value="${service.serviceName}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="hourlyRate" class="form-label">Hourly Rate ($)</label>
                        <input type="number" step="0.01" class="form-control" id="hourlyRate" name="hourlyRate" 
                               value="${service.hourlyRate}" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-12 d-flex">
                        <button type="submit" class="btn btn-primary me-2" name="action" value="update">Update Service</button>
                        <a href="manage-services" class="btn btn-secondary">Cancel</a>
                    </div>
                </div>
            </form>

            <!-- Display Success/Error Message -->
            <c:if test="${not empty message}">
                <div class="alert ${success ? 'alert-success' : 'alert-danger'} mt-3" role="alert">
                    ${message}
                </div>
            </c:if>
        </div>
    </body>
</html>