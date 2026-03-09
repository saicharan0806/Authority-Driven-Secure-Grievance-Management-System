document.addEventListener("DOMContentLoaded", function() {

    let form = document.getElementById("complaintForm")

    if (form) {

        form.addEventListener("submit", function(e) {

            e.preventDefault()

            let name = document.getElementById("name").value
            let category = document.getElementById("category").value
            let desc = document.getElementById("description").value

            let id = "CMP" + Math.floor(Math.random() * 10000)

            let complaint = {
                name: name,
                category: category,
                description: desc,
                status: "Submitted"
            }

            let complaints = JSON.parse(localStorage.getItem("complaints")) || {}

            complaints[id] = complaint

            localStorage.setItem("complaints", JSON.stringify(complaints))

            document.getElementById("result").innerText =
                "Complaint Registered Successfully. Your Complaint ID is: " + id

            form.reset()

        })

    }

})


function trackComplaint() {

    let id = document.getElementById("complaintId").value.toUpperCase()

    let complaints = JSON.parse(localStorage.getItem("complaints")) || {}

    if (complaints[id]) {

        let c = complaints[id]

        document.getElementById("statusResult").innerHTML =
            "Complaint ID: " + id + "<br>" +
            "Name: " + c.name + "<br>" +
            "Category: " + c.category + "<br>" +
            "Description: " + c.description + "<br>" +
            "Status: " + c.status

    } else {

        document.getElementById("statusResult").innerText =
            "Complaint ID not found"

    }

}


function loadComplaints() {

    let complaints = JSON.parse(localStorage.getItem("complaints")) || {}

    let table = document.getElementById("complaintTable")

    for (let id in complaints) {

        let c = complaints[id]

        let row = table.insertRow()

        row.insertCell(0).innerText = id
        row.insertCell(1).innerText = c.name
        row.insertCell(2).innerText = c.category
        row.insertCell(3).innerText = c.description
        row.insertCell(4).innerText = c.status

    }

}


function clearComplaints() {

    localStorage.removeItem("complaints")

    alert("All complaints cleared!")

    location.reload()

}