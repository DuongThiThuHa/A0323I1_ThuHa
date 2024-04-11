// // import {getAllRooms} from "../utils/ApiFunctions.jsx";
// // import {useEffect, useState} from "react";
// // import {Col, Row} from "react-bootstrap";
// // import {RoomFilter} from "../common/RoomFilter.jsx";
// // import {RoomPaginator} from "../common/RoomPaginator.jsx";
// //
// // export const ExistingRooms = () => {
// //     const [rooms, setRooms] = useState([{ id: "", roomType: "", roomPrice: ""}]);
// //     const [currentPage, setCurrentPage] = useState(1);
// //     const [roomsPerPage] = useState(8);
// //     const [isLoading, setIsLoading] = useState(false);
// //     const [filteredRooms, setFilteredRooms] = useState([{id: "", roomType: "", roomPrice: ""}]);
// //     const [selectRoomType, setSelectedRoomType] = useState("");
// //     const [successMessage, setSuccessMessage] = useState("");
// //     const [errorMessage, setErrorMessage] = useState("");
// //
// //
// //     useEffect(() => {
// //         fetchRooms()
// //     }, [])
// //
// //     const fetchRooms = async () => {
// //         setIsLoading(true)
// //         try {
// //             const result = await getAllRooms()
// //             setRooms(result)
// //             setIsLoading(false)
// //         } catch (error) {
// //             setErrorMessage(error.message)
// //             setIsLoading(false)
// //         }
// //     }
// //
// //     useEffect(() => {
// //         if (selectRoomType === "") {
// //             setFilteredRooms(rooms)
// //         } else {
// //             const filtered = rooms.filter((room) => room.roomType === selectRoomType)
// //             setFilteredRooms(filtered)
// //         }
// //         setCurrentPage(1)
// //     }, [rooms, selectRoomType])
// //
// //     const handlePaginaationClick = (pageNumber) => {
// //         setCurrentPage(pageNumber)
// //     }
// //
// //     const handleDelete = async (roomId) => {
// //         try {
// //             const result = await deleteRoom(roomId)
// //             if (result === ""){
// //                 setSuccessMessage(`Room No ${roomId} was delete`)
// //                 fetchRooms()
// //             } else {
// //                 console.error(`Error deleting room: ${result.message}`)
// //             }
// //         } catch (error){
// //             setErrorMessage(error.message)
// //         }
// //         setTimeout(() => {
// //             setErrorMessage("")
// //             setSuccessMessage("")
// //         },5000)
// //     }
// //
// //     const calculateTotalPages = (filteredRooms, roomsPerPage, rooms) => {
// //         const totalRooms = filteredRooms.length > 0 ? filteredRooms.length : rooms.length
// //         return Math.ceil(totalRooms / roomsPerPage)
// //
// //     }
// //
// //     const indexOfLastRoom = currentPage * roomsPerPage;
// //     const indexOfFirstRoom = indexOfLastRoom - roomsPerPage;
// //     const currentRooms = filteredRooms.slice(indexOfFirstRoom, indexOfLastRoom)
// //
// //
// //     return (
// //         <>
// //             <div className="container col-md-8 col-lg-6">
// //                 {successMessage && <p className="alert alert-success mt-5">{successMessage}</p>}
// //                 {errorMessage && <p className="alert alert-danger mt-5">{errorMessage}</p>}
// //             </div>
// //
// //             {isLoading ? (
// //                 <p>Loading existing rooms</p>
// //             ) : (
// //                 <section className="mt-5 mb-5 container">
// //                     <div className='d-flex justify-content-between mb-3 mt-5'>
// //                         <h2>Existing Rooms</h2>
// //                     </div>
// //
// //                     <Row>
// //                         <Col md={6} className="mb-2 mb-md-0">
// //                             <RoomFilter data={rooms} setFilteredData={setFilteredRooms}/>
// //                         </Col>
// //
// //                         <Col md={6} className="d-flex justify-content-end">
// //
// //                         </Col>
// //
// //                     </Row>
// //
// //
// //                         <table className="table table-bordered table-hover">
// //                             <thead>
// //                             <tr className="text-center">
// //                                 <th>ID</th>
// //                                 <th>Room Type</th>
// //                                 <th>Room Price</th>
// //                                 <th>Actions</th>
// //                             </tr>
// //                             </thead>
// //
// //                             <tbody>
// //                             {currentRooms.map((room) => (
// //                                 <tr key={room.id} className="text-center">
// //                                     <td>{room.roomType}</td>
// //                                     <td>{room.roomPrice}</td>
// //                                     <td>
// //                                         <button>View / Edit</button>
// //                                         <button>Delete</button>
// //                                     </td>
// //                                 </tr>
// //                             ))}
// //                             </tbody>
// //                         </table>
// //                         <RoomPaginator
// //                         currentPage={currentPage}
// //                         totalPages={calculateTotalPages(filteredRooms, roomsPerPage, rooms)}
// //                         onPageChange={handlePaginaationClick}
// //                         />
// //                 </section>
// //             )}
// //         </>
// //     )
// // }
//
// import { useEffect, useState } from "react";
// import { Col, Row } from "react-bootstrap";
// import { RoomFilter } from "../common/RoomFilter.jsx";
// import { RoomPaginator } from "../common/RoomPaginator.jsx";
// import { getAllRooms, deleteRoom } from "../utils/ApiFunctions.jsx"; // Import các hàm cần thiết từ ApiFunctions
//
// export const ExistingRooms = () => {
//     const [rooms, setRooms] = useState([]); // Khởi tạo rooms là một mảng rỗng
//     const [currentPage, setCurrentPage] = useState(1);
//     const [roomsPerPage] = useState(8);
//     const [isLoading, setIsLoading] = useState(false);
//     const [filteredRooms, setFilteredRooms] = useState([]); // Khởi tạo filteredRooms là một mảng rỗng
//     const [selectRoomType, setSelectedRoomType] = useState("");
//     const [successMessage, setSuccessMessage] = useState("");
//     const [errorMessage, setErrorMessage] = useState("");
//
//     useEffect(() => {
//         fetchRooms();
//     }, []);
//
//     const fetchRooms = async () => {
//         setIsLoading(true);
//         try {
//             const result = await getAllRooms();
//             setRooms(result);
//             setIsLoading(false);
//         } catch (error) {
//             setErrorMessage(error.message);
//             setIsLoading(false);
//         }
//     };
//
//     useEffect(() => {
//         if (selectRoomType === "") {
//             setFilteredRooms(rooms);
//         } else {
//             const filtered = rooms.filter((room) => room.roomType === selectRoomType);
//             setFilteredRooms(filtered);
//         }
//         setCurrentPage(1);
//     }, [rooms, selectRoomType]);
//
//     const handlePaginationClick = (pageNumber) => {
//         setCurrentPage(pageNumber);
//     };
//
//     // const handleDelete = async (roomId) => {
//     //     try {
//     //         const result = await deleteRoom(roomId);
//     //         if (result === "") {
//     //             setSuccessMessage(`Room No ${roomId} was deleted`);
//     //             fetchRooms();
//     //         } else {
//     //             console.error(`Error deleting room: ${result.message}`);
//     //         }
//     //     } catch (error) {
//     //         setErrorMessage(error.message);
//     //     }
//     //     setTimeout(() => {
//     //         setErrorMessage("");
//     //         setSuccessMessage("");
//     //     }, 5000);
//     // };
//
//     const calculateTotalPages = (filteredRooms) => {
//         return Math.ceil(filteredRooms.length / roomsPerPage);
//     };
//
//     const indexOfLastRoom = currentPage * roomsPerPage;
//     const indexOfFirstRoom = indexOfLastRoom - roomsPerPage;
//     const currentRooms = filteredRooms.slice(indexOfFirstRoom, indexOfLastRoom);
//
//     return (
//         <>
//             <div className="container col-md-8 col-lg-6">
//                 {successMessage && <p className="alert alert-success mt-5">{successMessage}</p>}
//                 {errorMessage && <p className="alert alert-danger mt-5">{errorMessage}</p>}
//             </div>
//
//             {isLoading ? (
//                 <p>Loading existing rooms</p>
//             ) : (
//                 <section className="mt-5 mb-5 container">
//                     <div className='d-flex justify-content-between mb-3 mt-5'>
//                         <h2>Existing Rooms</h2>
//                     </div>
//
//                     <Row>
//                         <Col md={6} className="mb-3 mb-md-0">
//                             <RoomFilter data={rooms} setFilteredData={setFilteredRooms} />
//                         </Col>
//
//                         <Col md={6} className="d-flex justify-content-end">
//
//                         </Col>
//                     </Row>
//
//                     <table className="table table-bordered table-hover">
//                         <thead>
//                         <tr className="text-center">
//                             <th>ID</th>
//                             <th>Room Type</th>
//                             <th>Room Price</th>
//                             <th>Actions</th>
//                         </tr>
//                         </thead>
//                         <tbody>
//                         {currentRooms.map((room) => (
//                             <tr key={room.id} className="text-center">
//                                 <td>{room.id}</td>
//                                 <td>{room.roomType}</td>
//                                 <td>{room.roomPrice}</td>
//                                 <td>
//                                     <button>View/Edit</button>
//                                     <button>Delete</button>
//                                     <button>Delete</button>
//                                 </td>
//                             </tr>
//                         ))}
//                         </tbody>
//                     </table>
//                     <RoomPaginator
//                         currentPage={currentPage}
//                         totalPages={calculateTotalPages(filteredRooms, roomsPerPage, rooms)}
//                         onPageChange={handlePaginationClick}
//                     />
//                 </section>
//             )}
//         </>
//     )
// };

