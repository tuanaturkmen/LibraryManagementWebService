package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: review.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReviewServiceGrpc {

  private ReviewServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ReviewService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.ReviewProto.GetReviewsRequest,
      com.example.grpc.ReviewProto.GetReviewsResponse> getGetReviewsByStudentIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReviewsByStudentID",
      requestType = com.example.grpc.ReviewProto.GetReviewsRequest.class,
      responseType = com.example.grpc.ReviewProto.GetReviewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.ReviewProto.GetReviewsRequest,
      com.example.grpc.ReviewProto.GetReviewsResponse> getGetReviewsByStudentIDMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.ReviewProto.GetReviewsRequest, com.example.grpc.ReviewProto.GetReviewsResponse> getGetReviewsByStudentIDMethod;
    if ((getGetReviewsByStudentIDMethod = ReviewServiceGrpc.getGetReviewsByStudentIDMethod) == null) {
      synchronized (ReviewServiceGrpc.class) {
        if ((getGetReviewsByStudentIDMethod = ReviewServiceGrpc.getGetReviewsByStudentIDMethod) == null) {
          ReviewServiceGrpc.getGetReviewsByStudentIDMethod = getGetReviewsByStudentIDMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.ReviewProto.GetReviewsRequest, com.example.grpc.ReviewProto.GetReviewsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReviewsByStudentID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ReviewProto.GetReviewsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ReviewProto.GetReviewsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReviewServiceMethodDescriptorSupplier("GetReviewsByStudentID"))
              .build();
        }
      }
    }
    return getGetReviewsByStudentIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.ReviewProto.DeleteReviewRequest,
      com.example.grpc.ReviewProto.DeleteReviewResponse> getDeleteReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReview",
      requestType = com.example.grpc.ReviewProto.DeleteReviewRequest.class,
      responseType = com.example.grpc.ReviewProto.DeleteReviewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.ReviewProto.DeleteReviewRequest,
      com.example.grpc.ReviewProto.DeleteReviewResponse> getDeleteReviewMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.ReviewProto.DeleteReviewRequest, com.example.grpc.ReviewProto.DeleteReviewResponse> getDeleteReviewMethod;
    if ((getDeleteReviewMethod = ReviewServiceGrpc.getDeleteReviewMethod) == null) {
      synchronized (ReviewServiceGrpc.class) {
        if ((getDeleteReviewMethod = ReviewServiceGrpc.getDeleteReviewMethod) == null) {
          ReviewServiceGrpc.getDeleteReviewMethod = getDeleteReviewMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.ReviewProto.DeleteReviewRequest, com.example.grpc.ReviewProto.DeleteReviewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteReview"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ReviewProto.DeleteReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ReviewProto.DeleteReviewResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReviewServiceMethodDescriptorSupplier("DeleteReview"))
              .build();
        }
      }
    }
    return getDeleteReviewMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReviewServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReviewServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReviewServiceStub>() {
        @java.lang.Override
        public ReviewServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReviewServiceStub(channel, callOptions);
        }
      };
    return ReviewServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReviewServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReviewServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReviewServiceBlockingStub>() {
        @java.lang.Override
        public ReviewServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReviewServiceBlockingStub(channel, callOptions);
        }
      };
    return ReviewServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReviewServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReviewServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReviewServiceFutureStub>() {
        @java.lang.Override
        public ReviewServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReviewServiceFutureStub(channel, callOptions);
        }
      };
    return ReviewServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getReviewsByStudentID(com.example.grpc.ReviewProto.GetReviewsRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ReviewProto.GetReviewsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReviewsByStudentIDMethod(), responseObserver);
    }

    /**
     */
    default void deleteReview(com.example.grpc.ReviewProto.DeleteReviewRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ReviewProto.DeleteReviewResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteReviewMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReviewService.
   */
  public static abstract class ReviewServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReviewServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReviewService.
   */
  public static final class ReviewServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReviewServiceStub> {
    private ReviewServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReviewServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReviewServiceStub(channel, callOptions);
    }

    /**
     */
    public void getReviewsByStudentID(com.example.grpc.ReviewProto.GetReviewsRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ReviewProto.GetReviewsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReviewsByStudentIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteReview(com.example.grpc.ReviewProto.DeleteReviewRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ReviewProto.DeleteReviewResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReviewMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReviewService.
   */
  public static final class ReviewServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReviewServiceBlockingStub> {
    private ReviewServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReviewServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReviewServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.ReviewProto.GetReviewsResponse getReviewsByStudentID(com.example.grpc.ReviewProto.GetReviewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReviewsByStudentIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.ReviewProto.DeleteReviewResponse deleteReview(com.example.grpc.ReviewProto.DeleteReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReviewMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReviewService.
   */
  public static final class ReviewServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReviewServiceFutureStub> {
    private ReviewServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReviewServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReviewServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.ReviewProto.GetReviewsResponse> getReviewsByStudentID(
        com.example.grpc.ReviewProto.GetReviewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReviewsByStudentIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.ReviewProto.DeleteReviewResponse> deleteReview(
        com.example.grpc.ReviewProto.DeleteReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReviewMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REVIEWS_BY_STUDENT_ID = 0;
  private static final int METHODID_DELETE_REVIEW = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REVIEWS_BY_STUDENT_ID:
          serviceImpl.getReviewsByStudentID((com.example.grpc.ReviewProto.GetReviewsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.ReviewProto.GetReviewsResponse>) responseObserver);
          break;
        case METHODID_DELETE_REVIEW:
          serviceImpl.deleteReview((com.example.grpc.ReviewProto.DeleteReviewRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.ReviewProto.DeleteReviewResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetReviewsByStudentIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.ReviewProto.GetReviewsRequest,
              com.example.grpc.ReviewProto.GetReviewsResponse>(
                service, METHODID_GET_REVIEWS_BY_STUDENT_ID)))
        .addMethod(
          getDeleteReviewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.ReviewProto.DeleteReviewRequest,
              com.example.grpc.ReviewProto.DeleteReviewResponse>(
                service, METHODID_DELETE_REVIEW)))
        .build();
  }

  private static abstract class ReviewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReviewServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.ReviewProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReviewService");
    }
  }

  private static final class ReviewServiceFileDescriptorSupplier
      extends ReviewServiceBaseDescriptorSupplier {
    ReviewServiceFileDescriptorSupplier() {}
  }

  private static final class ReviewServiceMethodDescriptorSupplier
      extends ReviewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReviewServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReviewServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReviewServiceFileDescriptorSupplier())
              .addMethod(getGetReviewsByStudentIDMethod())
              .addMethod(getDeleteReviewMethod())
              .build();
        }
      }
    }
    return result;
  }
}
