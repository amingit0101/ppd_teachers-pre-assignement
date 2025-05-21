<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList  " %>
<%@ page import="model.*" %>
<%
	
%>
<!DOCTYPE html5>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Teachers managment</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
            }
    
            .dashboard {
                display: flex;
                min-height: 100vh;
            }
    
            .sidebar {
                width: 250px;
                background-color: #2c3e50;
                color: white;
                padding: 20px;
            }
    
            .profile {
                text-align:center;
                margin-bottom: 30px;
            }
    
            .profile svg {
                width: 100px;
                height: 100px;
                border-radius: 50%;
                object-fit: cover;
            }
    
            .menu-btn {
                display: flex;
                align-items: center;
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                background: none;
                border: none;
                color: white;
                text-align: left;
                cursor: pointer;
            }
    
            .menu-btn i {
                margin-right: 10px;
                width: 20px;
            }
    
            .menu-btn.active {
                background-color: #3498db;
                border-radius: 5px;
            }
    
            .main-content {
                flex: 1;
                padding: 20px;
            }
    
            .content {
                display: block;
            }
    
            /* Forms */
            .form-container {
                background: white;
                padding: 20px;
                border-radius: 8px;
                margin-bottom: 20px;
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            }
    
            .form-group {
                margin-bottom: 15px;
            }
    
            .form-group label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }
    
            .form-group input,
            .form-group select {
                width: 100%;
                padding: 8px;
                border: 1px solid #ddd;
                border-radius: 4px;
            }
    
            .form-actions {
                margin-top: 20px;
                display: flex;
                gap: 10px;
            }
    
            /* Tables */
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
                background-color: white;
            }
    
            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
    
            th {
                background-color: #3498db;
                color: white;
            }
    
            tr:hover {
                background-color: #f5f5f5;
            }
    
            /* Buttons */
            .btn {
                padding: 8px 12px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                display: inline-flex;
                align-items: center;
            }
    
            .btn i {
                margin-right: 5px;
            }
    
            .btn-primary {
                background-color: #27ae60;
                color: white;
            }
    
            .btn-outline {
                background: transparent;
                border: 1px solid #3498db;
                color: #3498db;
            }
    
            .btn-danger {
                background-color: #e74c3c;
                color: white;
            }
    
            .badge {
                padding: 4px 8px;
                border-radius: 12px;
                font-size: 12px;
            }
    
            .badge-success {
                background-color: rgba(39, 174, 96, 0.2);
                color: #27ae60;
            }
    
            .badge-warning {
                background-color: rgba(241, 196, 15, 0.2);
                color: #f39c12;
            }
        </style>
    </head>
    <body>
        <div class="dashboard">
            <div class="sidebar">
                <div class="profile">
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="500" zoomAndPan="magnify" viewBox="0 0 375 374.999991" height="500" preserveAspectRatio="xMidYMid meet" version="1.0"><defs><clipPath id="3a17f349ad"><path d="M 0 20.757812 L 375 20.757812 L 375 331.257812 L 0 331.257812 Z M 0 20.757812 " clip-rule="nonzero"/></clipPath></defs><g clip-path="url(#3a17f349ad)"><path fill="#175582" d="M 253.609375 266.402344 L 253.609375 246.90625 C 253.609375 218.480469 241.171875 192.824219 221.46875 175.113281 C 230.894531 166.378906 243.5 161.015625 257.367188 161.015625 C 271.941406 161.015625 285.144531 166.933594 294.675781 176.460938 C 304.226562 186.011719 310.144531 199.21875 310.144531 213.773438 C 310.144531 228.347656 304.226562 241.554688 294.675781 251.082031 C 285.144531 260.632812 271.941406 266.550781 257.367188 266.550781 C 256.097656 266.550781 254.851562 266.507812 253.609375 266.402344 Z M 371.34375 198.097656 L 355.445312 192.925781 C 353.65625 192.347656 352.410156 191.015625 351.957031 189.230469 C 349.652344 180.367188 346.140625 171.972656 341.617188 164.296875 C 340.664062 162.679688 340.597656 160.847656 341.449219 159.191406 L 349.050781 144.289062 C 350.113281 142.214844 349.738281 139.78125 348.074219 138.140625 L 333.023438 123.070312 C 331.382812 121.429688 328.953125 121.054688 326.878906 122.117188 L 311.976562 129.71875 C 310.3125 130.546875 308.488281 130.511719 306.871094 129.550781 C 299.1875 125.023438 290.800781 121.515625 281.9375 119.210938 C 280.152344 118.753906 278.824219 117.511719 278.238281 115.722656 L 273.070312 99.820312 C 272.34375 97.601562 270.367188 96.167969 268.023438 96.167969 L 246.738281 96.167969 C 244.394531 96.167969 242.417969 97.601562 241.691406 99.820312 L 236.519531 115.722656 C 235.941406 117.511719 234.609375 118.753906 232.808594 119.210938 C 223.960938 121.515625 215.574219 125.023438 207.890625 129.550781 C 206.273438 130.503906 204.441406 130.546875 202.785156 129.71875 L 187.878906 122.117188 C 185.808594 121.054688 183.375 121.429688 181.734375 123.070312 L 166.664062 138.140625 C 165.023438 139.78125 164.648438 142.214844 165.710938 144.289062 L 169.175781 151.097656 C 184.890625 153.089844 199.445312 158.90625 211.902344 167.542969 C 223.617188 156.042969 239.664062 148.917969 257.371094 148.917969 C 275.289062 148.917969 291.503906 156.183594 303.238281 167.914062 C 314.984375 179.664062 322.234375 195.878906 322.234375 213.78125 C 322.234375 231.695312 314.992188 247.910156 303.238281 259.644531 C 291.503906 271.390625 275.296875 278.644531 257.371094 278.644531 C 256.105469 278.644531 254.859375 278.621094 253.617188 278.539062 L 253.617188 318.566406 C 253.617188 323.261719 252.304688 327.664062 250.027344 331.421875 L 268.03125 331.421875 C 270.375 331.421875 272.351562 329.984375 273.074219 327.765625 L 278.246094 311.84375 C 278.824219 310.078125 280.160156 308.832031 281.945312 308.355469 C 290.808594 306.070312 299.203125 302.5625 306.878906 298.039062 C 308.496094 297.085938 310.328125 297.019531 311.980469 297.867188 L 326.886719 305.472656 C 328.960938 306.535156 331.390625 306.160156 333.03125 304.496094 L 348.082031 289.445312 C 349.746094 287.804688 350.121094 285.375 349.058594 283.300781 L 341.453125 268.375 C 340.605469 266.710938 340.664062 264.910156 341.625 263.292969 C 346.148438 255.609375 349.65625 247.222656 351.941406 238.359375 C 352.417969 236.574219 353.664062 235.226562 355.429688 234.660156 L 371.351562 229.488281 C 373.570312 228.765625 375.007812 226.789062 375.007812 224.445312 L 375.007812 203.160156 C 375 200.792969 373.5625 198.824219 371.34375 198.097656 Z M 107.359375 241.304688 L 120.746094 265.054688 L 134.136719 241.304688 L 127.492188 162.429688 L 114.015625 162.429688 Z M 157 162.429688 L 139.621094 162.429688 L 146.34375 242.109375 L 146.324219 242.109375 C 146.402344 243.273438 146.175781 244.476562 145.554688 245.558594 L 126.019531 280.210938 C 125.5 281.148438 124.710938 281.976562 123.699219 282.53125 C 120.8125 284.171875 117.136719 283.132812 115.496094 280.246094 L 96.210938 246.050781 C 95.441406 244.929688 95.023438 243.558594 95.148438 242.101562 L 101.871094 162.421875 L 84.492188 162.421875 C 38.019531 162.429688 0 200.441406 0 246.90625 L 0 318.550781 C 0 325.613281 5.792969 331.40625 12.867188 331.40625 L 52.984375 331.40625 L 52.984375 280.8125 C 52.984375 277.472656 55.6875 274.769531 59.027344 274.769531 C 62.367188 274.769531 65.066406 277.472656 65.066406 280.8125 L 65.066406 331.40625 L 176.433594 331.40625 L 176.433594 280.8125 C 176.433594 277.472656 179.136719 274.769531 182.476562 274.769531 C 185.816406 274.769531 188.539062 277.472656 188.539062 280.8125 L 188.539062 331.40625 L 228.65625 331.40625 C 235.714844 331.40625 241.507812 325.613281 241.507812 318.550781 L 241.507812 246.90625 C 241.5 200.441406 203.488281 162.429688 157 162.429688 Z M 120.753906 140.113281 C 153.597656 140.113281 180.402344 113.304688 180.402344 80.464844 C 180.402344 47.601562 153.597656 20.816406 120.753906 20.816406 C 87.914062 20.816406 61.105469 47.601562 61.105469 80.464844 C 61.105469 113.304688 87.90625 140.113281 120.753906 140.113281 Z M 120.753906 140.113281 " fill-opacity="1" fill-rule="evenodd"/></g></svg>
                    <h3>Department Dean</h3>
                    <p>dean@university.edu</p>
                </div>
                <nav class="menu" >
                    <button class="menu-btn active" >
                        <i class="fas fa-chalkboard-teacher"></i>
                        <span>Manage Teachers</span>
                    </button>
                    <button class="menu-btn" >
                        <i class="fas fa-book"></i>
                        <span>Manage Courses</span>
                    </button>
                    <button class="menu-btn" >
                        <i class="fas fa-tasks"></i>
                        <span>Manage Assignments</span>
                    </button>
                    <button class="menu-btn" >
                        <i class="fas fa-sign-out-alt"></i>
                        <span>Log Out</span>
                    </button>
                </nav>
            </div>
            
            <!-- Main Content -->
            <div class="main-content">
                <!-- Teachers Section -->
                <section id="teachers" class="content">
                    <h2>Teachers Management</h2>
                    <button class="btn btn-primary" href="add_new_teacher.html">
                        <i class="fas fa-plus"></i>
                        <span>Add New Teacher</span>
                    </button>
                    <button class="btn btn-primary">
                        <i class="fas fa-plus"></i>
                        <span>Edit Teacher</span>
                    </button>
                    <!-- Teacher Form (Hidden by default) -->
                    <table class="teachers-table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Birthday</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                           <c:forEach items="${diplomas}" var="d">
           					 <option value="${d.ID}">${d.diploma_name}</option>
        				  </c:forEach> 
                        <tbody id="teachers-list">
                            <!-- Will be filled by JavaScript -->
                        </tbody>
                    </table>
                </section>
            </div>
        </div>
</html>