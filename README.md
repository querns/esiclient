Java ESI Client for EVE Online
=====

`esiclient` is a handcrafted ESI client for EVE Online. `esiclient` aims to
fulfill the following design characteristics:

* **Asynchronous:** Requests can occur in parallel, massively, constrained only
by ESI's rate limiting.
* **Immutability:** All generated requests, returned responses, and intermediate
objects are immutable.
* **Thread Safety:** Create one instance of a client and use it anywhere in your
project without fear.
* **Minimization of Concern:** The client performs as little work as possible to
function, leaving details like OAuth2 access tokens and caching of responses to
the user.
* **Ease of Use:** Well, for Java, anyways.

## Using `esiclient`

### Instantiating a client
First, create a `ClientConfig`:

```java
    ClientConfig config = ClientConfig.builder()
        .setUserAgent("My Cool Client For Handsome And Attractive Folks")
        .build();
```

If you're using [Google Guice](https://github.com/google/guice), add
`ClientModule` to your dependency injection container.

```java
   Injector injector = Guice.createInjector(
       // Other modules...
       new ClientModule(config)
   );
   
   Client client = injector.getInstance(Client.class);
```

If you're not using Google Guice, you can use `ClientFactory` to instantiate a
`Client`:

```java
    Client client = ClientFactory.instance(config);
```

### Making a request

A `Client` has a primary function: `sendRequest()`. Simply create a request
object and pass it to `sendRequest` to receive a future that resolves to the
output object once the request is complete.

#### Standard Requests

```java
    Client client = ...
    CompletableFuture<Response<ServerStatus>> future = client.sendRequest(
        new ServerStatusRequest()
    );
    
    Response<ServerStatus> statusResponse = future.join();
    if (statusResponse.getResponseObject().isPresent()) {
        ServerStatus status = statusResponse.getResponseObject.get();
        // ... do stuff with the status
    }
```

All response objects are immutable.

#### Paginated Requests

Requests that have paginated results will be detected by the client and
subsequent requests to fetch all of the pages of the response will automatically
be dispatched. The returned future won't join until all the pages have been
pulled or an error occurs.

```java
    Client client = ...
    Response<ImmutableList<Integer>> itemTypeIDsResponse = client.sendRequest(
        new ItemTypeIDsRequest()
    ).join();
    
    if (itemTypeIDsResponse.getResponseObject().isPresent()) {
        itemTypeIDsList = itemTypeIDsResponse.getResponseObject.get();
        // List contains more than 1,000 items
    }
```

Lists pulled from paginated endpoints will return results with the order intact;
page 2 results will be before page 3 results, and so on.

#### Requests With a Boolean Response

Requests using HTTP methods like `PUT` and `DELETE` typically only return an
HTTP status code signifying their success or failure. The pattern for working
with these endpoints is similarly simple:

```java
    Client client = ...
    BooleanResponse deleteContactsResponse = client.sendRequest(
        new DeleteContactsRequest(
            characterID,
            accessToken,
            ImmutableList.of(doomedContactID)
         )
    ).join();
    
    if (deleteContactsResponse.wasSuccessful()) {
        // rejoice at the deleting of the vile contact
    }
 
```

### Low Priority Mode

By default, a `Client` will execute up to 100 requests in parallel, depending on
the current error count. If you'd rather only execute one request at a time, use
`Client#withLowPriority()` to acquire a `Client` instance that does just that. 

```java
    Client client = ...
    CompletableFuture<Response<Integer>> response = client
        .withLowPriority()
        .executeRequest(new ItemTypeIDsRequest())
        ;
    // client executes the requests for each page sequentially instead of in
    // parallel
```

See the javadoc for `Client#withLowPriority()` for more details.

### Configuring the Client

`ClientConfig` can be used to configure the runtime characteristics of the
client.

Create a `ClientConfig` with `ClientConfig.builder()`. You MUST set a user agent
before the configuration object can be built.

Other options include:
 
* `setETagCache`: In order to enable ETag caching support, an instance of
  `ETagCache` must be provided to the client. The client defaults to 
  `NullETagCache`, which does nothing. A simple implementation, 
  `InMemoryETagCache`, is provided with the client, which caches all ETag
   information in memory. The user must implement his or her own variety of
   `ETagCache` to store ETag information in another fashion.
   
* `setExecutor`: The client will default to `Executors.newCachedThreadPool()`
  for generating threads. Use `setExecutor` to change this to an `Executor` of 
  your choice.
  
* `setESIServer`: If the server where ESI requests are sent somehow changes in
  the future, and the client is no longer being maintained, this option can 
  allow for continued operation of the client. Users should not need to use this
  configuration option normally.
  
* `setDataSource`: Allows the client to pull data from the Singularity test
  server instead of the live Tranquility server. Tranquility is the default.
 
