import axios from "axios";

export const getAll = async () => {
    try{
        const response = await axios.get('https://localhost:8081/typeBook');
        return response.data;
    } catch(error){
        console.log(error);
    }
}