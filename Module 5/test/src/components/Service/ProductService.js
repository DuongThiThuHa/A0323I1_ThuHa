import axios from "axios";

// Lấy danh sách
export const getAll = async () => {
    try {
        const response = await axios.get('http://localhost:8081/book');
        return response.data;
    }catch (error){
        console.log(error);
        throw error;
    }
}

export const add = async (book) => {
    try {
        const response = await axios.post('http://localhost:8081/book',book);
        return response.data;
    }catch (error){
        console.log(error);
        throw error;
    }
}

export const update = async (id, updateBook) => {
    try {
        const response = await axios.put(`http://localhost:8081/book/${id}`, updateBook);
        return response.data;
    } catch (error){
        console.log(error);
        throw error;
    }
}

