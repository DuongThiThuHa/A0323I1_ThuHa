const students = [
    {
    id: 1,
    name: "HaiTT",
    classroom: {
        id: 1,
        nameClass: "A03"
    },
    gender: true
    },
    {
        id: 2,
        name: "HaiTT",
        classroom: {
            id: 1,
            nameClass: "A03"
        },
        gender: false
    }]

export const getAll = () => {
    return students;
}

export const add = (student) => {
    students.push(student)
}