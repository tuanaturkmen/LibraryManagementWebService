import React, { useState } from "react";
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  Button,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";

function ReviewDialog({ open, onClose, onDelete, selectedStudent, reviews = [] }) {
  const [selectedRow, setSelectedRow] = useState(null);

  const handleRowClick = (review) => {
    console.log("Clicked row data:", review);
    setSelectedRow(review);
  };

  const handleDeleteClick = () => {
    onDelete(selectedRow.id);
  }

  return (
    <Dialog open={open} onClose={onClose} fullWidth maxWidth="md">
      <DialogTitle>Reviews for {selectedStudent.name}</DialogTitle>
      <DialogContent>
        {reviews.length === 0 ? (
          <Typography variant="body2">No reviews found.</Typography>
        ) : (
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>ID</TableCell>
                <TableCell>Book Name</TableCell>
                <TableCell>Rating</TableCell>
                <TableCell>Review Text</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {reviews.map((review) => (
                <TableRow
                  key={review.id}
                  onClick={() => handleRowClick(review)}
                  hover
                  selected={selectedRow?.id === review.id}
                  style={{ cursor: "pointer" }}
                >
                  <TableCell>{review.id}</TableCell>
                  <TableCell>{review.bookName}</TableCell>
                  <TableCell>{review.rating}</TableCell>
                  <TableCell>{review.reviewText}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        )}
      </DialogContent>
      <DialogActions>
        <Button onClick={handleDeleteClick} variant="outlined">
          Delete
        </Button>
        <Button onClick={onClose} variant="outlined">
          Close
        </Button>
      </DialogActions>
    </Dialog>
  );
}

export default ReviewDialog;