var form = document.getElementById("myForm"),
    imgInput = document.querySelector(".img"),
    file = document.getElementById("imgInput"),
    userName = document.getElementById("username"),
    password = document.getElementById("password"),
    conform = document.getElementById("conform"),
    name = document.getElementById("name"),
    gender = document.getElementById("gender"),
    address = document.getElementById("address"),
    email = document.getElementById("email"),
    phone = document.getElementById("phone"),
    card = document.getElementById("card"),
    birthday = document.getElementById("birthday"),
    submitBtn = document.querySelector(".submit"),
    userInfo = document.getElementById("data"),
    modal = document.getElementById("userForm"),
    modalTitle = document.querySelector("#userForm .modal-title"),
    newUserBtn = document.querySelector(".newUser")


let getData = localStorage.getItem('userProfile') ? JSON.parse(localStorage.getItem('userProfile')) : []
let isEdit = false, editId
showInfo()

newUserBtn.addEventListener('click', () => {
    submitBtn.innerText = 'Lưu',
        modalTitle.innerText = "Điền vào biểu mẫu"
    isEdit = false
    imgInput.src = "./image/Profile Icon.webp"
    form.reset()
})


file.onchange = function () {
    if (file.files[0].size < 1000000) {
        var fileReader = new FileReader();

        fileReader.onload = function (e) {
            imgUrl = e.target.result
            imgInput.src = imgUrl
        }

        fileReader.readAsDataURL(file.files[0])
    } else {
        alert("Kích thước ảnh quá lớn!")
    }
}


function showInfo() {
    document.querySelectorAll('.customerDetails').forEach(info => info.remove())
    getData.forEach((element, index) => {
        let createElement = `<tr class="customerDetails">
            <td>${index + 1}</td>
            <td><img src="${element.picture}" alt="" width="50" height="30"></td>
            <td>${element.customerUsername}</td>
            <td>${element.customerPassword}</td>
            <td>${element.customerConform}</td>
            <td>${element.customerName}</td>
            <td>${element.customerGender}</td>
            <td>${element.customerAddress}</td>
            <td>${element.customerEmail}</td>
            <td>${element.customerPhone}</td>
            <td>${element.customerCard}</td>
            <td>${element.customerBirthday}</td>


            <td>
                <button class="btn btn-primary" onclick="editInfo(${index}, '${element.picture}', '${element.customerUsername}', '${element.customerPassword}', '${element.customerConform}', '${element.customerName}', '${element.customerGender}', '${element.customerAddress}', '${element.customerEmail}', '${element.customerPhone}', '${element.customerCard}', '${element.customerBirthday}')" data-bs-toggle="modal" data-bs-target="#userForm"><i class="bi bi-pencil-square"></i></button>
                <button class="btn btn-danger" onclick="deleteInfo(${index})"><i class="bi bi-trash"></i></button>         
            </td>
        </tr>`

        userInfo.innerHTML += createElement
    })
}

showInfo()

function editInfo(index, pic, Username, Password, Conform, Name, Gender, Address, Email, Phone, Card, Birthday) {
        isEdit = true
        editId = index
        imgInput.src = pic
        userName.value = Username
        password.value = Password
        conform.value = Conform
        name.value = Name
        gender.value = Gender
        address.value = Address
        email.value = Email
        phone.value = Phone
        card.value = Card
        birthday.value = Birthday

    submitBtn.innerText = "Cập nhập"
    modalTitle.innerText = "Cập nhập lại thông tin"
}


function deleteInfo(index) {
    if (confirm("Bạn chắc chắn muốn xóa không ?")) {
        getData.splice(index, 1)
        localStorage.setItem("userProfile", JSON.stringify(getData))
        showInfo()
    }
}


form.addEventListener('submit', (e) => {
    e.preventDefault()

    const information = {
        picture: imgInput.src == undefined ? "./image/Profile Icon.webp" : imgInput.src,
        customerUsername: userName.value,
        customerPassword: password.value,
        customerConform: conform.value,
        customerName: name.value,
        customerGender: gender.value,
        customerAddress: address.value,
        customerEmail: email.value,
        customerPhone: phone.value,
        customerCard: card.value,
        customerBirthday: birthday.value,
    }

    if (!isEdit) {
        getData.push(information)
    } else {
        isEdit = false
        getData[editId] = information
    }

    localStorage.setItem('userProfile', JSON.stringify(getData))

    submitBtn.innerText = "Lưu"
    modalTitle.innerHTML = "Điền vào mẫu"

    showInfo()
    form.reset()
    imgInput.src = "./image/Profile Icon.webp"

})