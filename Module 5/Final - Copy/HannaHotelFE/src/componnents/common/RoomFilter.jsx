import {useState} from "react";

export const RoomFilter = ({data, setFilteredData}) =>{
    const [filter, setFilter] = useState("");

    const handleSelectChange = (e) => {
        const selectedRoomType = e.target.value
        setFilter(selectedRoomType)

        const filteredRooms = data.filter((room) =>
            room.roomType.toLowerCase().includes(selectedRoomType.toLowerCase()))
        setFilteredData(filteredRooms)
    }

    const clearFilter = () => {
        setFilteredData(data)
        setFilter("")
    }

    const roomTypes = ["", ...new Set(data.map((room) => room.roomType))]


    return(
        <div className="input-group mb-3">
            <span className="imput-group-text">
                Filter rooms by type
            </span>

            <select className="form-select"
                    value={filter}
                    onChange={handleSelectChange}>
                <option value={""}>
                    Select a room type to filter...
                  </option>
                {roomTypes.map((type, index) => (
                    <option key={index} value={String(type)}>
                        {String(type)}
                    </option>
                ))}
            </select>
            <button className="btn btn-hotel" type="button" onClick={clearFilter}>Clear Filter</button>
        </div>
    )

}