<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course Management System - Professor Interface</title>
    <style>
        body {
            background: #ffffff;
            color: #333;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 25px;
        }
        
    
        .page-title, .card-title, .section-title {
            color: #2c3e50;
        }
        .page-title { font-size: 24px; }
        .card-title { font-size: 18px; }

        /* .form-group { margin-bottom: 20px; } */
        .form-label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: #2c3e50;
        }
        .form-control {
            width: 100%;
            padding: 10px 15px;
            border: 1px solid #dee2e6;
            border-radius: 4px;
            font-size: 14px;
            background-color: #ffffff;
        }
        .selection-form {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-bottom: 30px;
        }
        
        /* Buttons */
        .btn {
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: all 0.3s;
            display: inline-flex;
            align-items: center;
        }
        .btn-primary { background: #3498db; color: #ffffff; }
        .btn-success { background: #27ae60; color: #ffffff; }
        .btn-warning { background: #f39c12; color: #ffffff; }
        .btn-danger { background: #e74c3c; color: #ffffff; }
        .logout-btn {
            background: #e74c3c;
            color: #ffffff;
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            font-size: 14px;
        }
        

        .table-responsive {
            overflow-x: auto;
            margin-bottom: 20px;
            border-radius: 8px;
            border: 1px solid #dee2e6;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 0;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #dee2e6;
        }
        th {
            background-color: #ffffff;
            color: #2c3e50;
            font-weight: 600;
            border-top: none;
        }
        tr {
            background-color: #ffffff;
        }
        
        /* Other elements */
        .professor-name {
            font-size: 22px;
            color: #ffffff;
            background: #34495e;
            margin-bottom: 20px;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
            border: none;
        }
       
        .badge-primary { background: #d4e6f1; color: #0c5460; }
        .badge-success { background: #d4edda; color: #155724; }
        .badge-warning { background: #fff3cd; color: #856404; }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
    <!-- Main content -->
    <main class="main-content">
        <!-- Professor information -->
        <div class="professor-name">
            <div>
                Dr. Ali Ahmed - Computer Science Department
                <br>
                <small>ali.ahmed@univ.edu</small>
                <br>
                <small>Associate Professor - PhD in Computer Science</small>
            </div>
            <a href="#" class="logout-btn">
                Logout
            </a>
        </div>
        
        <!-- Course selection section -->
        <h2 class="section-title">
            Course Selection
        </h2>
        
        <div class="card">
            <div class="card-header">
                <h2 class="card-title">Course Selection Form</h2>
            </div>
            
            <form class="selection-form">
                <div class="form-group">
                    <label class="form-label">Academic Year</label>
                    <select class="form-control" name="year">
                        <option value="">-- Select Year --</option>
                        <option value="1">First Year</option>
                        <option value="2">Second Year</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label class="form-label">Semester</label>
                    <select class="form-control" name="semester">
                        <option value="">-- Select Semester --</option>
                        <option value="1">First Semester</option>
                        <option value="2">Second Semester</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label class="form-label">Specialty</label>
                    <select class="form-control" name="specialty">
                        <option value="">-- Select Specialty --</option>
                        <option value="cs">Computer Security</option>
                        <option value="se">Software Engineering</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label class="form-label">Course</label>
                    <select class="form-control" name="course">
                        <option value="">-- Select Course --</option>
                        <option value="algo1">Algorithms and Static Data Structures</option>
                        <option value="arch1">Computer Architecture 1</option>
                        <option value="os1">Introduction to Operating Systems 1</option>
                        <option value="math1">Mathematical Analysis 1</option>
                        <option value="algebra1">Algebra 1</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label class="form-label">Teaching Type</label>
                    <select class="form-control" name="teaching_type">
                        <option value="">-- Select Type --</option>
                        <option value="lecture">Lecture</option>
                        <option value="td">Tutorial</option>
                        <option value="both">Lecture + Tutorial</option>
                    </select>
                </div>
                
                <button type="submit" class="btn btn-success">
                    <i class="fas fa-check"></i>
                    Confirm Selection
                </button>
            </form>
        </div>
        
        <!-- My current selections -->
        <div class="card">
            <div class="card-header">
                <h2 class="card-title">My Current Selections</h2>
            </div>
            
            <div class="table-responsive">
                <table>
                    <thead>
                        <tr>
                            <th>Course</th>
                            <th>Year</th>
                            <th>Semester</th>
                            <th>Teaching Type</th>
                            <th>Groups</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Algorithms and Static Data Structures</td>
                            <td>First</td>
                            <td>First</td>
                            <td>Tutorial</td>
                            <td>3</td>
                            <td><span class="badge badge-success">Approved</span></td>
                            <td>
                                <span class="btn btn-warning" style="opacity: 0.5; cursor: not-allowed;">
                                    <i class="fas fa-edit"></i>
                                </span>
                                <span class="btn btn-danger" style="opacity: 0.5; cursor: not-allowed;">
                                    <i class="fas fa-trash"></i>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>Computer Architecture 1</td>
                            <td>First</td>
                            <td>First</td>
                            <td>Lecture</td>
                            <td>1</td>
                            <td><span class="badge badge-success">Approved</span></td>
                            <td>
                                <span class="btn btn-warning" style="opacity: 0.5; cursor: not-allowed;">
                                    <i class="fas fa-edit"></i>
                                </span>
                                <span class="btn btn-danger" style="opacity: 0.5; cursor: not-allowed;">
                                    <i class="fas fa-trash"></i>
                                </span>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
        <!-- Course list section -->
        <h2 class="section-title">
            Course Catalog
        </h2>
        
        <div class="card">
            <div class="card-header">
                <h2 class="card-title">Computer Science Engineering Courses</h2>
            </div>
            
            <div class="table-responsive">
                <table>
                    <thead>
                        <tr>
                            <th>Course Code</th>
                            <th>Course Name</th>
                            <th>Year</th>
                            <th>Semester</th>
                            <th>Lecture Hours</th>
                            <th>Tutorial Hours</th>
                            <th>Weight</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>INF101</td>
                            <td>Algorithms and Static Data Structures</td>
                            <td>First</td>
                            <td>First</td>
                            <td>30</td>
                            <td>30</td>
                            <td>4</td>
                        </tr>
                        <tr>
                            <td>INF102</td>
                            <td>Computer Architecture 1</td>
                            <td>First</td>
                            <td>First</td>
                            <td>30</td>
                            <td>15</td>
                            <td>3</td>
                        </tr>
                        <tr>
                            <td>INF103</td>
                            <td>Introduction to Operating Systems 1</td>
                            <td>First</td>
                            <td>First</td>
                            <td>30</td>
                            <td>30</td>
                            <td>3</td>
                        </tr>
                        <tr>
                            <td>MATH101</td>
                            <td>Mathematical Analysis 1</td>
                            <td>First</td>
                            <td>First</td>
                            <td>45</td>
                            <td>30</td>
                            <td>4</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
        <!-- Colleagues section -->
        <h2 class="section-title">
            Teaching Colleagues
        </h2>
        
        <div class="card">
            <div class="card-header">
                <h2 class="card-title">Computer Science Department Faculty</h2>
            </div>
            
            <div class="table-responsive">
                <table>
                    <thead>
                        <tr>
                            <th>Professor Name</th>
                            <th>Academic Rank</th>
                            <th>Email</th>
                            <th>Specialization</th>
                            <th>Selected Courses</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Dr. Mohamed Abdullah</td>
                            <td>Associate Professor - PhD</td>
                            <td>mohamed.abdullah@univ.edu</td>
                            <td>Artificial Intelligence</td>
                            <td>Artificial Intelligence, Machine Learning</td>
                            <td>
                                <a href="mailto:mohamed.abdullah@univ.edu" class="btn btn-primary">
                                    <i class="fas fa-envelope"></i> Contact
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>Dr. Sara Ahmed</td>
                            <td>Assistant Professor - PhD</td>
                            <td>sara.ahmed@univ.edu</td>
                            <td>Information Security</td>
                            <td>Computer Security, Cryptography</td>
                            <td>
                                <a href="mailto:sara.ahmed@univ.edu" class="btn btn-primary">
                                    <i class="fas fa-envelope"></i> Contact
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>Dr. Youssef Khalid</td>
                            <td>Associate Professor - PhD</td>
                            <td>youssef.khalid@univ.edu</td>
                            <td>Database Systems</td>
                            <td>Database Systems, Content Management Systems</td>
                            <td>
                                <a href="mailto:youssef.khalid@univ.edu" class="btn btn-primary">
                                    <i class="fas fa-envelope"></i> Contact
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</body>
</html>