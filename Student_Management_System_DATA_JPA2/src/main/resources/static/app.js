const baseUrl = "http://localhost:8080/students";

function renderTable(data) {
  const tbody = document.querySelector("#studentsTable tbody");
  if (!tbody) return; // only runs on students.html
  tbody.innerHTML = "";
  data.forEach(student => {
    let row = `<tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.department}</td>
      <td>${student.gmail}</td>
      <td>${student.admissionYear}</td>
      <td><button onclick="deleteStudent(${student.id})">🗑️ Delete</button></td>
    </tr>`;
    tbody.innerHTML += row;
  });
}

function getAllStudents() {
  fetch(baseUrl)
    .then(res => res.json())
    .then(data => renderTable(data))
    .catch(err => console.error(err));
}

function getByDepartment() {
  const dept = document.getElementById("deptInput").value;
  fetch(`${baseUrl}/department/${dept}`)
    .then(res => res.json())
    .then(data => renderTable(data))
    .catch(err => console.error(err));
}

function getByName() {
  const name = document.getElementById("nameInput").value;
  fetch(`${baseUrl}/name/${name}`)
    .then(res => res.json())
    .then(data => renderTable(data))
    .catch(err => console.error(err));
}

function deleteStudent(id) {
  if (confirm("Are you sure you want to delete this student?")) {
    fetch(`${baseUrl}/${id}`, { method: "DELETE" })
      .then(() => {
        alert("❌ Student deleted successfully!");
        getAllStudents();
      })
      .catch(err => console.error(err));
  }
}

// Handle Add Student form (on add-student.html)
const studentForm = document.getElementById("studentForm");
if (studentForm) {
  studentForm.addEventListener("submit", function(e) {
    e.preventDefault();
    
    const student = {
      name: document.getElementById("name").value,
      department: document.getElementById("department").value,
      gmail: document.getElementById("gmail").value,
      admissionYear: parseInt(document.getElementById("admissionYear").value)
    };

    fetch(baseUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(student)
    })
    .then(res => res.json())
    .then(() => {
      alert("✅ Student added successfully!");
      window.location.href = "students.html"; // redirect back
    })
    .catch(err => console.error(err));
  });
}
