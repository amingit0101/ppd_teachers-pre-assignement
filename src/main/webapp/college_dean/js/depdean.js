// Data
let teachers = [
    {id: 1, name: "Ahmed Mohamed", email: "ahmed@university.edu", phone: "123456789",
     birthday: "1980-01-01", grade: "A"},
    {id: 2, name: "Sara Ali", email: "sara@university.edu", phone: "987654321",
     birthday: "1985-02-02", grade: "B"},
];

let courses = [
    {id: 1, name: "Mathematics",coefficient:5, code: "MATH101", hours: 3},
    {id: 2, name: "Physics", coefficient:4, code: "PHYS101", hours: 4}
];

let formations = [
    {id: 1, name: "Computer Science", duration: "3 years", diploma: "Bachelor"},
    {id: 2, name: "Engineering", duration: "5 years", diploma: "Master"}
];

// This would come from the scheduling system in a real application
let assignments = [
    {
        id: 1,
        teacherId: 1,
        courseId: 1,
        hours: 30,
        semester: "Fall 2023",
        status: "active"
    },
    {
        id: 2,
        teacherId: 2,
        courseId: 2,
        hours: 25,
        semester: "Spring 2023",
        status: "pending"
    }
];

// Current selections
let currentTeacherId = null;
let currentCourseId = null;
let currentFormationId = null;

// Show selected section
function showSection(sectionId) {
    // Hide all sections
    document.querySelectorAll('.content').forEach(section => {
        section.classList.remove('active');
    });
    
    // Show selected section
    document.getElementById(sectionId).classList.add('active');
    
    // Update sidebar menu
    document.querySelectorAll('.menu-btn').forEach(btn => {
        btn.classList.remove('active');
        if (btn.getAttribute('onclick').includes(sectionId)) {
            btn.classList.add('active');
        }
    });
}

// ===== TEACHER FUNCTIONS =====
function showTeacherForm(teacherId = null) {
    const form = document.getElementById('teacher-form');
    const formTitle = document.getElementById('teacher-form-title');
    
    if (teacherId) {
        // Edit mode
        currentTeacherId = teacherId;
        const teacher = teachers.find(t => t.id === teacherId);
        formTitle.textContent = 'Edit Teacher';
        document.getElementById('teacher-name').value = teacher.name;
        document.getElementById('teacher-email').value = teacher.email;
        document.getElementById('teacher-phone').value = teacher.phone;
        document.getElementById('teacher-birthday').value = teacher.birthday;
        document.getElementById('teacher-grade').value = gradeLetterToValue(teacher.grade);
    } else {
        // Add mode
        currentTeacherId = null;
        formTitle.textContent = 'Add Teacher';
        document.getElementById('teacherForm').reset();
    }
    
    form.style.display = 'block';
}

function hideTeacherForm() {
    document.getElementById('teacher-form').style.display = 'none';
    currentTeacherId = null;
}

function saveTeacher(event) {
    event.preventDefault();
    let grad = document.getElementById('teacher-grade').value;
    const teacher = {
        name: document.getElementById('teacher-name').value,
        email: document.getElementById('teacher-email').value,
        phone: document.getElementById('teacher-phone').value,
        birthday: document.getElementById('teacher-birthday').value,
        grade: gradeValueToLetter(grad)
    };
    
    if (currentTeacherId) {
        // Update existing teacher
        const index = teachers.findIndex(t => t.id === currentTeacherId);
        teachers[index] = {...teacher, id: currentTeacherId};
    } else {
        // Add new teacher
        const newId = teachers.length > 0 ? Math.max(...teachers.map(t => t.id)) + 1 : 1;
        teachers.push({...teacher, id: newId});
    }
    
    displayTeachers();
    hideTeacherForm();
}

function gradeLetterToValue(letter) {
   const grades = {'A': 1, 'B': 2, 'C': 3};
   return grades[letter] || 0;
}

function gradeValueToLetter(value) {
   const grades = { 1 :'A',  2:'B',  3:'C'};
   return grades[value] || 0;
}

function deleteTeacher(event, id) {
    event.stopPropagation();
    if (confirm('Are you sure you want to delete this teacher?')) {
        teachers = teachers.filter(teacher => teacher.id !== id);
        displayTeachers();
    }
}

// ===== COURSE FUNCTIONS =====
function showCourseForm(courseId = null) {
    const form = document.getElementById('course-form');
    const formTitle = document.getElementById('course-form-title');
    
    if (courseId) {
        // Edit mode
        currentCourseId = courseId;
        const course = courses.find(c => c.id === courseId);
        formTitle.textContent = 'Edit Course';
        document.getElementById('course-name').value = course.name;
        document.getElementById('course-code').value = course.code;
        document.getElementById('course-Coefficient').value=course.coefficient;
        document.getElementById('course-hours').value = course.hours;
    } else {
        // Add mode
        currentCourseId = null;
        formTitle.textContent = 'Add Course';
        document.getElementById('courseForm').reset();
    }
    
    form.style.display = 'block';
}

function hideCourseForm() {
    document.getElementById('course-form').style.display = 'none';
    currentCourseId = null;
}

function saveCourse(event) {
    event.preventDefault();
    
    const course = {
        name: document.getElementById('course-name').value,
        code: document.getElementById('course-code').value,
        coefficient: document.getElementById('course-Coefficient').value,
        hours: parseInt(document.getElementById('course-hours').value)
    };
    
    if (currentCourseId) {
        // Update existing course
        const index = courses.findIndex(c => c.id === currentCourseId);
        courses[index] = {...course, id: currentCourseId};
    } else {
        // Add new course
        const newId = courses.length > 0 ? Math.max(...courses.map(c => c.id)) + 1 : 1;
        courses.push({...course, id: newId});
    }
    
    displayCourses();
    hideCourseForm();
}

function deleteCourse(event, id) {
    event.stopPropagation();
    if (confirm('Are you sure you want to delete this course?')) {
        courses = courses.filter(course => course.id !== id);
        displayCourses();
    }
}

// ===== FORMATION FUNCTIONS =====
function showFormationForm(formationId = null) {
    const form = document.getElementById('formation--form');
    const formTitle = document.getElementById('formation-form-title');
    
    if (formationId) {
        // Edit mode
        currentFormationId = formationId;
        const formation = formations.find(f => f.id === formationId);
        formTitle.textContent = 'Edit Formation';
        document.getElementById('formation-name').value = formation.name;
        document.getElementById('duration').value = formation.duration;
        document.getElementById('dep').value = formation.diploma;
    } else {
        // Add mode
        currentFormationId = null;
        formTitle.textContent = 'Add Formation';
        document.getElementById('FormationForm').reset();
    }
    
    form.style.display = 'block';
}

function hideFormationForm() {
    document.getElementById('formation--form').style.display = 'none';
    currentFormationId = null;
}

function saveFormation(event) {
    event.preventDefault();
    
    const formation = {
        name: document.getElementById('formation-name').value,
        duration: document.getElementById('duration').value,
        diploma: document.getElementById('dep').value
    };
    
    if (currentFormationId) {
        // Update existing formation
        const index = formations.findIndex(f => f.id === currentFormationId);
        formations[index] = {...formation, id: currentFormationId};
    } else {
        // Add new formation
        const newId = formations.length > 0 ? Math.max(...formations.map(f => f.id)) + 1 : 1;
        formations.push({...formation, id: newId});
    }
    
    displayFormations();
    hideFormationForm();
}

function deleteFormation(event, id) {
    event.stopPropagation();
    if (confirm('Are you sure you want to delete this formation?')) {
        formations = formations.filter(formation => formation.id !== id);
        displayFormations();
    }
}

// ===== ASSIGNMENT FUNCTIONS =====
function acceptAssignment(event, id) {
    event.stopPropagation();
    const assignment = assignments.find(a => a.id === id);
    if (assignment) {
        assignment.status = "active";
        displayAssignments();
        alert("Assignment accepted successfully");
    }
}

function rejectAssignment(event, id) {
    event.stopPropagation();
    if (confirm('Are you sure you want to reject this assignment?')) {
        assignments = assignments.filter(a => a.id !== id);
        displayAssignments();
    }
}

// ===== DISPLAY FUNCTIONS =====
function displayTeachers() {
    let teachersList = document.getElementById('teachers-list');
    teachersList.innerHTML = '';
    
    teachers.forEach(teacher => {
        let row = `
            <tr>
                <td>${teacher.name}</td>
                <td>${teacher.email}</td>
                <td>${teacher.phone}</td>
                <td>${teacher.birthday}</td>
                <td>${teacher.grade}</td>
                <td>
                    <button class="btn btn-outline" onclick="showTeacherForm(${teacher.id})">
                        <i class="fas fa-edit"></i>
                        <span>Edit</span>
                    </button>
                    <button class="btn btn-danger" onclick="deleteTeacher(event, ${teacher.id})">
                        <i class="fas fa-trash"></i>
                        <span>Delete</span>
                    </button>
                </td>
            </tr>
        `;
        teachersList.innerHTML += row;
    });
}

function displayCourses() {
    let coursesList = document.getElementById('courses-list');
    coursesList.innerHTML = '';
    
    courses.forEach(course => {
        let row = `
            <tr>
                <td>${course.name}</td>
                <td>${course.code}</td>
                <td>${course.coefficient}</td>
                <td>${course.hours}</td>
                <td>
                    <button class="btn btn-outline" onclick="showCourseForm(${course.id})">
                        <i class="fas fa-edit"></i>
                        <span>Edit</span>
                    </button>
                    <button class="btn btn-danger" onclick="deleteCourse(event, ${course.id})">
                        <i class="fas fa-trash"></i>
                        <span>Delete</span>
                    </button>
                </td>
            </tr>
        `;
        coursesList.innerHTML += row;
    });
}

function displayFormations() {
    let formationsList = document.getElementById('formations-list');
    formationsList.innerHTML = '';
    
    formations.forEach(formation => {
        let row = `
            <tr>
                <td>${formation.name}</td>
                <td>${formation.duration}</td>
                <td>${formation.diploma}</td>
                <td>
                    <button class="btn btn-outline" onclick="showFormationForm(${formation.id})">
                        <i class="fas fa-edit"></i>
                        <span>Edit</span>
                    </button>
                    <button class="btn btn-danger" onclick="deleteFormation(event, ${formation.id})">
                        <i class="fas fa-trash"></i>
                        <span>Delete</span>
                    </button>
                </td>
            </tr>
        `;
        formationsList.innerHTML += row;
    });
}

function displayAssignments() {
    let assignmentsList = document.getElementById('assignments-list');
    assignmentsList.innerHTML = '';
    
    assignments.forEach(assignment => {
        let teacher = teachers.find(t => t.id === assignment.teacherId);
        let course = courses.find(c => c.id === assignment.courseId);
        let statusBadge = assignment.status === 'active' ? 
            '<span class="badge badge-success">Active</span>' : 
            '<span class="badge badge-warning">Pending Approval</span>';
        
        let actions = '';
        if (assignment.status === 'pending') {
            actions = `
                <button class="btn btn-primary" onclick="acceptAssignment(event, ${assignment.id})">
                    <i class="fas fa-check"></i>
                    <span>Accept</span>
                </button>
                <button class="btn btn-danger" onclick="rejectAssignment(event, ${assignment.id})">
                    <i class="fas fa-times"></i>
                    <span>Reject</span>
                </button>
            `;
        } else {
            actions = `
                <button class="btn btn-danger" onclick="rejectAssignment(event, ${assignment.id})">
                    <i class="fas fa-trash"></i>
                    <span>Remove</span>
                </button>
            `;
        }
        
        let row = `
            <tr>
                <td>${teacher.name}</td>
                <td>${course.name}</td>
                <td>${assignment.hours}</td>
                <td>${assignment.semester}</td>
                <td>${statusBadge}</td>
                <td>${actions}</td>
            </tr>
        `;
        assignmentsList.innerHTML += row;
    });
}

// Logout function
function logout() {
    if (confirm('Are you sure you want to log out?')) {
        alert('Logged out successfully');
        // Here you would redirect to login page
    }
}

// Initialize the dashboard
window.onload = function() {
    displayTeachers();
    displayCourses();
    displayFormations();
    displayAssignments();
};