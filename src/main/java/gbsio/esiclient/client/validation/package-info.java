/**
 * Contains classes for validating objects required by some requests.
 *
 * All classes that consume objects validated by these classes will call their
 * associated validator automatically and throw if the object does not pass.
 * Access to these validators was left public for the testing / implementation
 * convenience of the user.
 */
package gbsio.esiclient.client.validation;