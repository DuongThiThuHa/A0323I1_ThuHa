import axios from "axios"

export const api = axios.create({
    baseURL: "http://localhost:8443"
})

// Header
// export const getHeader = () => {
//     const token = localStorage.getItem("token")
//     return {
//         Authorization: `Bearer ${token}`,
//         "Content-Type": "application/json"
//     }
// }

// Add room
export async function addRoom(photo, roomType, roomPrice) {
    const formData = new FormData();
    formData.append("photo", photo)
    formData.append("roomType", roomType)
    formData.append("roomPrice", roomPrice)

    const response = await api.post("/rooms/add/newRoom", formData, {
        // headers:
    })
    if (response.status === 201) {
        return true
    } else {
        return false
    }
}

// Type Room
export async function getRoomTypes() {
    try {
        const response = await api.get("/rooms/room/roomTypes");
        return response.data
    } catch (error) {
        error.message
    }
}

// Get all room
export async function getAllRooms(){
    try{
        const result = await  api.get("/rooms/allRooms");
        return result.data;
    }catch (error){
        throw new Error("Error fetching rooms!")
    }
}

// Delete Room
export async function deleteRoom(roomId){
    try {
        const result = await api.delete(`/room/delete/room/${roomId}`, {
            headers: getHeader()
        })
        return result.data
    } catch (error){
        throw new Error(`Error deleting room ${error.message}`)
    }
}

