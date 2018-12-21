package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TransferReversal extends ApiResource
    implements BalanceTransactionSource, MetadataStore<TransferReversal> {
  /** Amount, in %s. */
  Long amount;

  /** Balance transaction that describes the impact on your account balance. */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<BalanceTransaction> balanceTransaction;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  Long created;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  String currency;

  /** Linked payment refund for the transfer reversal. */
  String destinationPaymentRefund;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  String id;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format.
   */
  @Getter(onMethod = @__({@Override}))
  Map<String, String> metadata;

  /** String representing the object's type. Objects of the same type share the same value. */
  String object;

  /** ID of the refund responsible for the transfer reversal. */
  String sourceRefund;

  /** ID of the transfer that was reversed. */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Transfer> transfer;

  /** Get id of expandable `balanceTransaction` object. */
  public String getBalanceTransaction() {
    return (this.balanceTransaction != null) ? this.balanceTransaction.getId() : null;
  }

  public void setBalanceTransaction(String id) {
    this.balanceTransaction = ApiResource.setExpandableFieldId(id, this.balanceTransaction);
  }

  /** Get expanded `balanceTransaction`. */
  public BalanceTransaction getBalanceTransactionObject() {
    return (this.balanceTransaction != null) ? this.balanceTransaction.getExpanded() : null;
  }

  public void setBalanceTransactionObject(BalanceTransaction expandableObject) {
    this.balanceTransaction =
        new ExpandableField<BalanceTransaction>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `transfer` object. */
  public String getTransfer() {
    return (this.transfer != null) ? this.transfer.getId() : null;
  }

  public void setTransfer(String id) {
    this.transfer = ApiResource.setExpandableFieldId(id, this.transfer);
  }

  /** Get expanded `transfer`. */
  public Transfer getTransferObject() {
    return (this.transfer != null) ? this.transfer.getExpanded() : null;
  }

  public void setTransferObject(Transfer expandableObject) {
    this.transfer = new ExpandableField<Transfer>(expandableObject.getId(), expandableObject);
  }

  /**
   * Updates the specified reversal by setting the values of the parameters passed. Any parameters
   * not provided will be left unchanged.
   *
   * <p>This request only accepts metadata and description as arguments.
   */
  public TransferReversal update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specified reversal by setting the values of the parameters passed. Any parameters
   * not provided will be left unchanged.
   *
   * <p>This request only accepts metadata and description as arguments.
   */
  public TransferReversal update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url;
    if (this.getTransfer() != null) {
      url =
          String.format(
              "%s%s",
              Stripe.getApiBase(),
              String.format("/v1/transfers/%s/reversals/%s", this.getTransfer(), this.getId()));
    } else {
      throw new InvalidRequestException(
          "Unable to construct url because [transfer] field(s) are all null",
          null,
          null,
          null,
          0,
          null);
    }
    return request(ApiResource.RequestMethod.POST, url, params, TransferReversal.class, options);
  }
}
