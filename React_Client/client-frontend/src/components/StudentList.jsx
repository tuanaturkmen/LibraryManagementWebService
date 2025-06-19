import React, { useEffect, useState } from "react";
import { DataGrid } from "@mui/x-data-grid";
import Button from "@mui/material/Button";
import axios  from "axios"
import AddUpdateStudentDialog from "./Dialogs/AddUpdateStudentDialog";
import ReviewDialog from "./Dialogs/ReviewDialog";
import EnumDialogActionType from "../enums/EnumDialogActionType";

const columns = [
    { field: "id",              headerName: "ID",               width: 100 },
    { field: "name",            headerName: "Name",             width: 300 },
    { field: "surname",         headerName: "Surname",          width: 200 },
    { field: "department",      headerName: "Department",       width: 200 },
    { field: "year",            headerName: "Year",             width: 200 },
];

function StudentList() {

    const [students, setStudents] = useState([]);
    const [selectedRowId, setSelectedRowId] = useState(null);
    const [isAddDialogOpen, setIsAddDialogOpen] = useState(false);
    const [isReviewDialogOpen, setIsReviewDialogOpen] = useState(false);
    const [action, setAction] = useState(null);
    const [selecteStudent, setSelectedStudent] = useState({
        id: "",
        title: "",
        author: "",
        publicationYear: "",
        isAvailable: false,
    });
    const [reviews, setReviews] = useState([]);

    useEffect(() =>  {
        getStudentList();
    }, [])

    const getStudentList = () => {
        axios.get("http://localhost:8090/api/students")
        .then((res) => {
            console.log(res.data)
            const studentList = Array.isArray(res.data) ? res.data : [];
            setStudents(studentList);
        })
        .catch((err) => {
            console.error(err)
        });
    }

    const handleDeleteClick = () => {

        if (selectedRowId == undefined) {
            return;
        }

        axios.delete(`http://localhost:8090/api/students/${selectedRowId}`)
        .then((res) => {
            console.log("Response: ", res.data)
            getStudentList();
        })
        .catch((err) => {
            console.error(err)
        });
    }

    const handleUpdateClick = () => {

        if (selectedRowId == undefined) {
            return;
        }

        const selectedRow = students.find((row) => row.id === selectedRowId);
        setSelectedStudent(selectedRow);
        setAction(EnumDialogActionType.UPDATE);
        setIsAddDialogOpen(true);
    }

    const handleAddClick = () => {
        setSelectedStudent({
            id: "",
            name: "",
            surname: "",
            department: "",
            year: "",
        });
        setAction(EnumDialogActionType.ADD)
        setIsAddDialogOpen(true);
    }

    const handleShowReviewsClick = () => {

        const selectedRow = students.find((row) => row.id === selectedRowId);
        setSelectedStudent(selectedRow);

        axios.get(`http://localhost:8090/api/students/${selectedRow.id}/reviews`)
        .then((res) => {
            setReviews(res.data);
            setIsReviewDialogOpen(true);
        })
        .catch(console.error);
    }

    const addNewStudent = (newStudent, action) => {
        if (action == EnumDialogActionType.ADD.value) {
            axios.post("http://localhost:8090/api/students", newStudent)
            .then((res) => {
                console.log("Response: ", res.data)
                getStudentList();
            })
            .catch((err) => {
                console.error(err)
            });
        } else if (action == EnumDialogActionType.UPDATE.value) {
            axios.put("http://localhost:8090/api/students", newStudent)
            .then((res) => {
                console.log("Response: ", res.data)
                getStudentList();
            })
            .catch((err) => {
                console.error(err)
            });
        }

        setIsAddDialogOpen(false);
    }

    const handleDeleteReview = (reviewId) => {
        
        if (reviewId === undefined || !selecteStudent?.id) {
            return;
        }

        axios.delete(`http://localhost:8090/api/students/${selecteStudent.id}/reviews/${reviewId}`)
            .then((res) => {
                console.log("Response: ", res.data);
                return axios.get(`http://localhost:8090/api/students/${selecteStudent.id}/reviews`);
            })
            .then((res) => {
                setReviews(res.data);
            })
            .catch((err) => {
                console.error(err);
            });
    }

    return (
        <>
            <DataGrid
                rows={students || []}
                columns={columns}
                pageSizeOptions={[5, 10, 25, { value: -1, label: 'All' }]}
                checkboxSelection
                disableMultipleRowSelection
                initialState={{
                    pagination: { paginationModel: { pageSize: 5 } },
                }}
                onRowSelectionModelChange={(newSelection) => {
                    const selectedId = Array.from(newSelection.ids)[0];
                    setSelectedRowId(selectedId);
                }}
            />
            <div 
                style={{ 
                    display: "flex", 
                    flexDirection: "row-reverse",
                    margin: "20px 0px 0px 0px",
                }}
            >
                <Button variant="outlined" style={{ marginLeft: 8 }} onClick={() => handleShowReviewsClick()}>SHOW REVIEWS</Button>
                <Button variant="outlined" style={{ marginLeft: 8 }} onClick={() => handleDeleteClick()}>DELETE</Button>
                <Button variant="outlined" style={{ marginLeft: 8 }} onClick={() => handleUpdateClick()}>UPDATE</Button>
                <Button variant="outlined" style={{ marginLeft: 8 }} onClick={() => handleAddClick()}>ADD</Button>
            </div>
            <AddUpdateStudentDialog
                open={isAddDialogOpen}
                selectedStudent={selecteStudent}
                action={action}
                handleClose={() => setIsAddDialogOpen(false)}
                onSubmit={(newStudent) => addNewStudent(newStudent, action.value)}
            />
            <ReviewDialog
                open={isReviewDialogOpen}
                onDelete={(reviewId) => handleDeleteReview(reviewId)}
                onClose={() => setIsReviewDialogOpen(false)}
                selectedStudent={selecteStudent}
                reviews={reviews}
            />
        </>
    );
}

export default StudentList;
