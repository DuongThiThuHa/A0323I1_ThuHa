import axios from "axios";

export const getAll = async () => {
    try {
        const response = await axios.get('http://localhost:8081/products');
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
}


export const add = async (product) => {
    try {
        const response = await axios.post('http://localhost:8081/products', product);
        return response.data;
    }catch (error){
        console.log(error);
        throw error;
    }
}
