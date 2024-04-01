// // SS5
//
// // const students = [
// //     {
// //         id: 1,
// //         name: "Thu Ha",
// //         nameClass: "A12",
// //         age: 24,
// //         address: "Quang Nam",
// //         gender: String
// //     },
// //     {
// //         id: 2,
// //         name: "Yen Nhi",
// //         nameClass: "A03",
// //         age: 24,
// //         address: "Da Nang",
// //         gender: String
// //     },
// //     {
// //         id: 3,
// //         name: "Anh Thu",
// //         nameClass: "A05",
// //         age: 21,
// //         address: "Da Nang",
// //         gender: String
// //     }
// // ]
// //
// // export const getAll = () => {
// //     return students;
// // }
// //
// // export const add = (student) => {
// //     students.push(student)
// // }
//
//
// // SS6
// import axios from "axios";
// export const getAll = async () => {
//     try {
//         const response = await axios.get('http://localhost:8081/students');
//         return response.data;
//     }catch (error){
//         console.log(error);
//     }
// }
//
// export const add = async (students) => {
//     try {
//         await axios.post('http://localhost:8081/students',students);
//         return true;
//     }catch (error){
//         return false;
//     }
// }
//
// export const update = async  (students) => {
//     try {
//         await  axios.get('http://localhost:8081/students/edit', students);
//         return true;
//     }
//     catch (error){
//         return false;
//     }
// }
//
// export const getById = async (students) => {
//     try {
//         await axios.getById('http://localhost:8081/students', students);
//         return true;
//     } catch (error){
//         return false;
//     }
// }


import axios from "axios";

// Lấy danh sách học sinh
export const getAll = async () => {
    try {
        const response = await axios.get('http://localhost:8081/students');
        return response.data;
    } catch (error) {
        console.log(error);
        throw error; // Rethrow lỗi để component gọi có thể xử lý
    }
}

// Thêm học sinh mới
export const add = async (student) => {
    try {
        const response = await axios.post('http://localhost:8081/students', student);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
}

// Cập nhật thông tin học sinh
export const update = async (id, updatedStudent) => {
    try {
        const response = await axios.put(`http://localhost:8081/students/${id}`, updatedStudent);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
}

// Xóa học sinh
export const remove = async (id) => {
    try {
        const response = await axios.delete(`http://localhost:8081/students/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
}

// Lấy thông tin của một học sinh dựa trên id
export const getById = async (id) => {
    try {
        const response = await axios.get(`http://localhost:8081/students/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
}
