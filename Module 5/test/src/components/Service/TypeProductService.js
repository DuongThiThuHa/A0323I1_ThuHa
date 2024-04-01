import axios from "axios";

export const getAll = async () => {
    try {
        const response = await axios.get('http://localhost:8081/type');
        return response.data;
    } catch (error){
        console.log(error);
    }
}