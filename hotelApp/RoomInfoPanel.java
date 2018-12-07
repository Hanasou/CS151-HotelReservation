package hotelApp;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;

/**
 * Panel that holds the view and controller for viewing room info. Shows the room number, price, and valid reservations for each room.
 * @author Roy Zhang
 *
 */

public class RoomInfoPanel extends JPanel{

	private DataStorage db;
	private ArrayList<JButton> buttons;
	private ArrayList<Room> rooms;
	private TimeInterval ti;
	
	public RoomInfoPanel(DataStorage db) {
		this.db = db;
		this.buttons = new ArrayList<JButton>();
		this.rooms = db.getRooms();
		this.ti = new TimeInterval(LocalDate.now(), LocalDate.now());
		setLayout(new FlowLayout());
		JPanel header = new JPanel();
		header.add(new JLabel("Room View"));
		JPanel roomButtons = new JPanel(new GridLayout(5, 4));
		Integer roomNum = 0;
		for (int i = 0; i < 20; i++) {
			JButton b = new JButton("");
			roomNum = rooms.get(i).getRoomNumber();
			b.setText(roomNum.toString());
			buttons.add(b);
			roomButtons.add(b);
		}
		
		JTextArea roomInfoView = new JTextArea(10, 20);
		roomInfoView.setEditable(false);
		
		for (JButton b : buttons) {
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Room room = db.getRoomByNumber(Integer.parseInt(b.getText()));
					roomInfoView.setText("Room Info" + "\n");
					roomInfoView.append(room.toString() + "\n");
					roomInfoView.append("Valid Reservations: " + "\n");
					for (Reservation res : room.getReservations()) {
						roomInfoView.append(res.toStringShort());
					}
				}
			});
		}
		
		JScrollPane scroll = new JScrollPane(roomInfoView);
		JPanel viewArea = new JPanel(new FlowLayout());
		viewArea.add(scroll);
		JPanel controllerArea = new JPanel(new BorderLayout());
		controllerArea.add(header, BorderLayout.NORTH);
		controllerArea.add(roomButtons, BorderLayout.SOUTH);
		add(controllerArea);
		add(viewArea);
	}
}
