package modelo;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableCellEditor;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class JTextFieldTableCellEditor extends AbstractCellEditor implements TableCellEditor {
	private JTextField textField;
	private Object cellValue;

	public JTextFieldTableCellEditor() {
		textField = new JTextField();
		((AbstractDocument) textField.getDocument()).setDocumentFilter(new NumberDocumentFilter());
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateCellValue();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateCellValue();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateCellValue();
			}
		});
	}

	private void updateCellValue() {
		cellValue = textField.getText();
		fireEditingStopped();
	}

	@Override
	public Object getCellEditorValue() {
		return cellValue;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		textField.setText(value != null ? value.toString() : "");
		cellValue = value;
		return textField;
	}

	private class NumberDocumentFilter extends DocumentFilter {
		@Override
		public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
				throws BadLocationException {
			StringBuilder sb = new StringBuilder();
			sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
			sb.insert(offset, string);

			if (isNumeric(sb.toString())) {
				super.insertString(fb, offset, string, attr);
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
				throws BadLocationException {
			StringBuilder sb = new StringBuilder();
			sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
			sb.replace(offset, offset + length, text);

			if (isNumeric(sb.toString())) {
				super.replace(fb, offset, length, text, attrs);
			}
		}

		private boolean isNumeric(String str) {
			return str.matches("\\d*");
		}
	}
}
