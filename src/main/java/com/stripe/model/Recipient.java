package com.stripe.model;

import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;

import java.util.Map;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Recipient extends ApiResource implements MetadataStore<Recipient>, HasId {
  @Getter(onMethod = @__({@Override})) String id;
  String object;
  BankAccount activeAccount;
  RecipientCardCollection cards;
  Long created;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) ExpandableField<Card> defaultCard;
  Boolean deleted;
  String description;
  String email;
  Boolean livemode;
  @Getter(onMethod = @__({@Override})) Map<String, String> metadata;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) ExpandableField<Account> migratedTo;
  String name;
  String type;
  Boolean verified;

  // <editor-fold desc="defaultCard">
  public String getDefaultCard() {
    return (this.defaultCard != null) ? this.defaultCard.getId() : null;
  }

  public void setDefaultCard(String defaultCardId) {
    this.defaultCard = ApiResource.setExpandableFieldId(defaultCardId, this.defaultCard);
  }

  public Card getDefaultCardObject() {
    return (this.defaultCard != null) ? this.defaultCard.getExpanded() : null;
  }

  public void setDefaultCardObject(Card c) {
    this.defaultCard = new ExpandableField<Card>(c.getId(), c);
  }
  // </editor-fold>

  // <editor-fold desc="migratedTo">
  public String getMigratedTo() {
    return (this.migratedTo != null) ? this.migratedTo.getId() : null;
  }

  public void setMigratedTo(String migratedToId) {
    this.migratedTo = ApiResource.setExpandableFieldId(migratedToId, this.migratedTo);
  }

  public Account getMigratedToObject() {
    return (this.migratedTo != null) ? this.migratedTo.getExpanded() : null;
  }

  public void setMigratedToObject(Account c) {
    this.migratedTo = new ExpandableField<Account>(c.getId(), c);
  }
  // </editor-fold>

  // <editor-fold desc="create">
  /**
   * Create a recipient.
   */
  public static Recipient create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /**
   * Create a recipient.
   */
  public static Recipient create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return request(RequestMethod.POST, classUrl(Recipient.class), params, Recipient.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="delete">
  /**
   * Delete a recipient.
   */
  public Recipient delete() throws StripeException {
    return delete((RequestOptions) null);
  }

  /**
   * Delete a recipient.
   */
  public Recipient delete(RequestOptions options) throws StripeException {
    return request(RequestMethod.DELETE, instanceUrl(Recipient.class, this.id), null,
        Recipient.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="list">
  /**
   * List all recipients.
   */
  public static RecipientCollection list(Map<String, Object> params) throws StripeException {
    return list(params, null);
  }

  /**
   * List all recipients.
   */
  public static RecipientCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return requestCollection(classUrl(Recipient.class), params, RecipientCollection.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="retrieve">
  /**
   * Retrieve a recipient.
   */
  public static Recipient retrieve(String id) throws StripeException {
    return retrieve(id, (RequestOptions) null);
  }

  /**
   * Retrieve a recipient.
   */
  public static Recipient retrieve(String id, RequestOptions options) throws StripeException {
    return retrieve(id, null, options);
  }

  /**
   * Retrieve a recipient.
   */
  public static Recipient retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return request(RequestMethod.GET, instanceUrl(Recipient.class, id), params, Recipient.class,
        options);
  }
  // </editor-fold>

  // <editor-fold desc="update">
  /**
   * Update a recipient.
   */
  @Override
  public Recipient update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Update a recipient.
   */
  @Override
  public Recipient update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return request(RequestMethod.POST, instanceUrl(Recipient.class, this.id), params,
        Recipient.class, options);
  }
  // </editor-fold>
}
