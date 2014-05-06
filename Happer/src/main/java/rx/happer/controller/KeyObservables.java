package rx.happer.controller;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

public enum KeyObservables { ;//no class instances

	public static Observable<KeyEvent> keyPress(Scene scene) {
		return Observable.create((Subscriber<? super KeyEvent> subscriber) -> {
			EventHandler<KeyEvent> handler = (event) -> subscriber.onNext(event);
			scene.addEventHandler(KeyEvent.KEY_PRESSED, handler);
			
			subscriber.add(Subscriptions.create(() -> scene.removeEventHandler(KeyEvent.KEY_PRESSED, handler)));
		});
	}
	
	public static Observable<KeyEvent> keyPress(Node node) {
		return Observable.create((Subscriber<? super KeyEvent> subscriber) -> {
			EventHandler<KeyEvent> handler = (event) -> subscriber.onNext(event);
			node.addEventHandler(KeyEvent.KEY_PRESSED, handler);
			
			subscriber.add(Subscriptions.create(() -> node.removeEventHandler(KeyEvent.KEY_PRESSED, handler)));
		});
	}
	
	public static Observable<KeyEvent> rightArrowKey(Node node) {
		return keyPress(node).filter(event -> event.getCode() == KeyCode.RIGHT);
	}
	
	public static Observable<KeyEvent> leftArrowKey(Node node) {
		return keyPress(node).filter(event -> event.getCode() == KeyCode.LEFT);
	}
	
	public static Observable<KeyEvent> upArrowKey(Node node) {
		return keyPress(node).filter(event -> event.getCode() == KeyCode.UP);
	}
	
	public static Observable<KeyEvent> downArrowKey(Node node) {
		return keyPress(node).filter(event -> event.getCode() == KeyCode.DOWN);
	}
}
