package com.example.grpc;

import com.example.grpc.ReviewProto.DeleteReviewRequest;
import com.example.grpc.ReviewProto.DeleteReviewResponse;
import com.example.grpc.ReviewProto.GetReviewsRequest;
import com.example.grpc.ReviewProto.GetReviewsResponse;
import com.example.grpc.ReviewProto.ReviewData;
import com.example.grpc.ReviewServiceGrpc.ReviewServiceImplBase;
import com.example.grpc.model.Review;
import com.example.grpc.service.ReviewManager;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@GrpcService
public class ReviewServiceImpl extends ReviewServiceImplBase {

    @Autowired
    private ReviewManager reviewManager;

    @Override
    public void getReviewsByStudentID(GetReviewsRequest request, StreamObserver<GetReviewsResponse> responseObserver) {
		System.out.println("[GRPC] getReviewsByStudentID request is received.");
        Collection<Review> reviews = reviewManager.getReviewsByStudentID(request.getStudentId());

        GetReviewsResponse.Builder responseBuilder = GetReviewsResponse.newBuilder();
        for (Review r : reviews) {
            ReviewData reviewData = ReviewData.newBuilder()
                .setId(r.getId())
                .setStudentId(r.getStudentId())
                .setStudentName(r.getStudentName())
                .setBookName(r.getBookName())
                .setRating(r.getRating())
                .setReviewText(r.getReviewText())
                .build();

            responseBuilder.addReviews(reviewData);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
    
    @Override
    public void deleteReview(DeleteReviewRequest request, StreamObserver<DeleteReviewResponse> responseObserver) {
		System.out.println("[GRPC] deleteReview request is received.");
        long reviewId = request.getReviewId();
        boolean result = reviewManager.deleteReviewById(reviewId);

        DeleteReviewResponse response = DeleteReviewResponse.newBuilder()
                .setSuccess(result)
                .setMessage(result ? "Review deleted successfully." : "Review not found.")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
