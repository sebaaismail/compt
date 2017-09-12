package com.sebaainf.calculate;

import com.jgoodies.common.internal.StringResourceAccessor;
import com.jgoodies.forms.builder.I15dPanelBuilder;
import com.jgoodies.forms.layout.ConstantSize;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by ${sebaainf.com} on 24/02/2015.
 */
public class IsmFormBuilder extends I15dPanelBuilder {

    Font font = MyApp.theme.font;

    /**
     * Holds the row specification that is reused to describe rows
     * that are intended for labels and components.
     *
     * @see #setDefaultRowSpec(com.jgoodies.forms.layout.RowSpec)
     */
    private RowSpec defaultRowSpec = FormSpecs.PREF_ROWSPEC;

    /**
     * Holds the row specification that is reused to describe
     * the constant gaps between component lines.
     *
     * @see #setLineGapSize(com.jgoodies.forms.layout.ConstantSize)
     */
    private RowSpec lineGapSpec = FormSpecs.LINE_GAP_ROWSPEC;

    /**
     * Holds the row specification that describes the constant gaps
     * between paragraphs.
     *
     * @see #setParagraphGapSize(com.jgoodies.forms.layout.ConstantSize)
     */
    private RowSpec paragraphGapSpec = FormSpecs.PARAGRAPH_GAP_ROWSPEC;

    /**
     * Holds the offset of the leading column - often 0 or 1.
     *
     * @see #getLeadingColumnOffset()
     * @see #setLeadingColumnOffset(int)
     * @see #getLeadingColumn()
     */
    private int leadingColumnOffset = 0;

    /**
     * Determines whether new data rows are being grouped or not.
     *
     * @see #isRowGroupingEnabled()
     * @see #setRowGroupingEnabled(boolean)
     */
    private boolean rowGroupingEnabled = false;


    // Instance Creation ****************************************************

    /**
     * Constructs a {@code MyFormBuilder} for the given
     * layout.
     *
     * @param layout the {@code FormLayout} to be used
     * @throws NullPointerException if {@code layout} is {@code null}
     */
    public IsmFormBuilder(FormLayout layout) {

        this(layout, new JPanel(null));
    }


    /**
     * Constructs a {@code MyFormBuilder} for the given
     * layout and panel.
     *
     * @param layout    the {@code FormLayout} to be used
     * @param container the layout container
     * @throws NullPointerException if {@code layout} or {@code container} is {@code null}
     */
    public IsmFormBuilder(FormLayout layout, JPanel container) {

        this(layout, (StringResourceAccessor) null, container);
    }


    /**
     * Constructs a {@code MyFormBuilder} for the given
     * layout and resource bundle.
     *
     * @param layout the {@code FormLayout} to be used
     * @param bundle the {@code ResourceBundle} used to lookup i15d
     *               strings
     * @throws NullPointerException if {@code layout} is {@code null}
     */
    public IsmFormBuilder(FormLayout layout, ResourceBundle bundle) {

        super(layout, bundle);
    }


    /**
     * Constructs a {@code MyFormBuilder} for the given
     * layout, resource bundle, and panel.
     *
     * @param layout    the {@code FormLayout} to be used
     * @param container the layout container
     * @param bundle    the {@code ResourceBundle} used to lookup i15d
     *                  strings
     * @throws NullPointerException if {@code layout} or {@code container} is {@code null}
     */
    public IsmFormBuilder(FormLayout layout, ResourceBundle bundle, JPanel container) {

        super(layout, bundle, container);
    }


    /**
     * Constructs a {@code MyFormBuilder} for the given
     * layout and resource bundle.
     *
     * @param layout    the {@code FormLayout} to be used
     * @param localizer used to lookup i15d strings
     * @throws NullPointerException if {@code layout} is {@code null}
     */
    public IsmFormBuilder(FormLayout layout, StringResourceAccessor localizer) {

        super(layout, localizer);
    }


    /**
     * Constructs a {@code MyFormBuilder} for the given
     * layout, resource bundle, and panel.
     *
     * @param layout    the {@code FormLayout} to be used
     * @param container the layout container
     * @param localizer used to lookup i15d strings
     * @throws NullPointerException if {@code layout} or {@code container} is {@code null}
     */
    public IsmFormBuilder(FormLayout layout, StringResourceAccessor localizer, JPanel container) {

        super(layout, localizer, container);
    }


    // Frequently Used Panel Properties ***************************************

    @Override
    public IsmFormBuilder background(Color background) {

        super.background(background);
        return this;
    }


    @Override
    public IsmFormBuilder border(Border border) {

        super.border(border);
        return this;
    }


    @Override
    public IsmFormBuilder border(String emptyBorderSpec) {

        super.border(emptyBorderSpec);
        return this;
    }


    @Override
    public IsmFormBuilder opaque(boolean b) {

        super.opaque(b);
        return this;
    }


    // Modern (Cascading) Style Configuration *********************************

    /**
     * Sets the row specification that shall be used for component rows.
     * It is {@link com.jgoodies.forms.layout.FormSpecs#PREF_ROWSPEC} by default.
     *
     * @param defaultRowSpec the RowSpec to be used for component rows
     */
    public IsmFormBuilder defaultRowSpec(RowSpec defaultRowSpec) {

        this.defaultRowSpec = defaultRowSpec;
        return this;
    }


    /**
     * Sets the size of gaps between component lines using the given
     * constant size.<p>
     * <p/>
     * <strong>Examples:</strong><pre>
     * .lineGapSize(Sizes.ZERO);
     * .lineGapSize(Sizes.DLUY9);
     * .lineGapSize(Sizes.pixel(1));
     * </pre>
     *
     * @param lineGapSize the {@code ConstantSize} that describes
     *                    the size of the gaps between component lines
     */
    public IsmFormBuilder lineGapSize(ConstantSize lineGapSize) {

        RowSpec rowSpec = RowSpec.createGap(lineGapSize);
        this.lineGapSpec = rowSpec;
        return this;
    }


    /**
     * Sets the size of gaps between paragraphs using the given
     * constant size.<p>
     * <p/>
     * <strong>Examples:</strong><pre>
     * .setParagraphGapSize(Sizes.DLUY14);
     * .setParagraphGapSize(Sizes.dluY(22));
     * .setParagraphGapSize(Sizes.pixel(42));
     * </pre>
     *
     * @param paragraphGapSize the {@code ConstantSize} that describes
     *                         the size of the gaps between paragraphs
     */
    public IsmFormBuilder paragraphGapSize(ConstantSize paragraphGapSize) {

        RowSpec rowSpec = RowSpec.createGap(paragraphGapSize);
        this.paragraphGapSpec = rowSpec;
        return this;
    }


    /**
     * Sets the offset of the leading column, often 0 or 1.
     *
     * @param columnOffset the new offset of the leading column
     */
    public IsmFormBuilder leadingColumnOffset(int columnOffset) {

        this.leadingColumnOffset = columnOffset;
        return this;
    }


    /**
     * Enables or disables the grouping of new data rows.
     *
     * @param enabled indicates grouping enabled, false disabled
     */
    public IsmFormBuilder rowGroupingEnabled(boolean enabled) {

        rowGroupingEnabled = enabled;
        return this;
    }


    // Old Style Configuration ************************************************

    /**
     * Returns the row specification that is used for component rows.
     *
     * @return the {@code RowSpec} used for component rows
     * @since 1.2
     * @deprecated Obsolete; will be deleted from the next version
     */
    @Deprecated
    public RowSpec getDefaultRowSpec() {

        return defaultRowSpec;
    }


    /**
     * Sets the row specification that shall be used for component rows.
     * It is {@link com.jgoodies.forms.layout.FormSpecs#PREF_ROWSPEC} by default.
     *
     * @param defaultRowSpec the RowSpec to be used for component rows
     * @since 1.2
     * @deprecated Replaced by {@link #defaultRowSpec(com.jgoodies.forms.layout.RowSpec)}
     */
    @Deprecated
    public void setDefaultRowSpec(RowSpec defaultRowSpec) {

        this.defaultRowSpec = defaultRowSpec;
    }


    /**
     * Returns the row specification that is used to separate component row.
     *
     * @return the {@code RowSpec} that is used to separate component rows
     * @deprecated Obsolete; will be deleted from the next version
     */
    @Deprecated
    public RowSpec getLineGapSpec() {

        return lineGapSpec;
    }


    /**
     * Sets the size of gaps between component lines using the given
     * constant size.<p>
     * <p/>
     * <strong>Examples:</strong><pre>
     * .setLineGapSize(Sizes.ZERO);
     * .setLineGapSize(Sizes.DLUY9);
     * .setLineGapSize(Sizes.pixel(1));
     * </pre>
     *
     * @param lineGapSize the {@code ConstantSize} that describes
     *                    the size of the gaps between component lines
     * @deprecated Replaced by {@link #lineGapSize(com.jgoodies.forms.layout.ConstantSize)}
     */
    @Deprecated
    public void setLineGapSize(ConstantSize lineGapSize) {

        RowSpec rowSpec = RowSpec.createGap(lineGapSize);
        this.lineGapSpec = rowSpec;
    }


    /**
     * Sets the size of gaps between paragraphs using the given
     * constant size.<p>
     * <p/>
     * <strong>Examples:</strong><pre>
     * .setParagraphGapSize(Sizes.DLUY14);
     * .setParagraphGapSize(Sizes.dluY(22));
     * .setParagraphGapSize(Sizes.pixel(42));
     * </pre>
     *
     * @param paragraphGapSize the {@code ConstantSize} that describes
     *                         the size of the gaps between paragraphs
     * @deprecated Replaced by {@link #lineGapSize(com.jgoodies.forms.layout.ConstantSize)}
     */
    @Deprecated
    public void setParagraphGapSize(ConstantSize paragraphGapSize) {

        RowSpec rowSpec = RowSpec.createGap(paragraphGapSize);
        this.paragraphGapSpec = rowSpec;
    }


    /**
     * Returns the offset of the leading column, often 0 or 1.
     *
     * @return the offset of the leading column
     * @deprecated Obsolete; will be deleted from the next version
     */
    @Deprecated
    public int getLeadingColumnOffset() {

        return leadingColumnOffset;
    }


    /**
     * Sets the offset of the leading column, often 0 or 1.
     *
     * @param columnOffset the new offset of the leading column
     * @deprecated Replaced by {@link #leadingColumnOffset(int)}
     */
    @Deprecated
    public void setLeadingColumnOffset(int columnOffset) {

        this.leadingColumnOffset = columnOffset;
    }


    /**
     * Returns whether new data rows are being grouped or not.
     *
     * @return true indicates grouping enabled, false disabled
     * @deprecated Obsolete; will be deleted from the next version
     */
    @Deprecated
    public boolean isRowGroupingEnabled() {

        return rowGroupingEnabled;
    }


    /**
     * Enables or disables the grouping of new data rows.
     *
     * @param enabled indicates grouping enabled, false disabled
     * @deprecated Replaced by {@link #rowGroupingEnabled(boolean)}
     */
    @Deprecated
    public void setRowGroupingEnabled(boolean enabled) {

        rowGroupingEnabled = enabled;
    }


    // Appending Rows ********************************************************

    /**
     * Appends a row with this builder's line gap size.
     *
     * @see #lineGapSize(com.jgoodies.forms.layout.ConstantSize)
     * @see #appendRow(String)
     */
    public final void appendLineGapRow() {

        appendRow(lineGapSpec);
    }


    // Filling Columns ******************************************************

    /**
     * Adds a component to the panel using the default constraints
     * with a column span of 1. Then proceeds to the next data column.
     *
     * @param component the component to add
     */
    public void append(Component component) {

        if (component.getClass() == JTabbedPane.class) {
            component.setFont(font.deriveFont(Font.ITALIC, font.getSize() + 1f));
        }
        append(component, 1);
    }


    /**
     * Adds a component to the panel using the default constraints with
     * the given columnSpan. Proceeds to the next data column.
     *
     * @param component  the component to append
     * @param columnSpan the column span used to add
     */
    public void append(Component component, int columnSpan) {

        ensureCursorColumnInGrid();
        ensureHasGapRow(lineGapSpec);
        ensureHasComponentLine();

        add(component, createLeftAdjustedConstraints(columnSpan));
        nextColumn(columnSpan + 1);

    }


    /**
     * Adds two components to the panel; each component will span a single
     * data column. Proceeds to the next data column.
     *
     * @param c1 the first component to add
     * @param c2 the second component to add
     */
    public void append(Component c1, Component c2) {

        append(c1);
        append(c2);
    }


    /**
     * Adds three components to the panel; each component will span a single
     * data column. Proceeds to the next data column.
     *
     * @param c1 the first component to add
     * @param c2 the second component to add
     * @param c3 the third component to add
     */
    public void append(Component c1, Component c2, Component c3) {

        append(c1);
        append(c2);
        append(c3);
    }


    // Appending Labels with optional components ------------------------------

    /**
     * Adds a text label to the panel and proceeds to the next column.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @return the added label
     */
    public JLabel append(String textWithMnemonic) {

        JLabel label = getComponentFactory().createLabel(textWithMnemonic);
        append(label);

        return label;
    }


    /**
     * Adds a text label and component to the panel.
     * Then proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the given component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @param component        the component to add
     * @return the added label
     */
    public JLabel append(String textWithMnemonic, Component component) {

        if (component.getClass() == JButton.class) {
            component.setFont(font.deriveFont(font.getSize() + 1f));
        } else {
            component.setFont(font);
        }
        return append(textWithMnemonic, component, 1);
    }


    /**
     * Adds a text label and component to the panel; the component will span
     * the specified number columns. Proceeds to the next data column,
     * and goes to the next line if the boolean flag is set.<p>
     * <p/>
     * The created label is labeling the given component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @param c                the component to add
     * @param nextLine         true forces a next line
     * @return the added label
     * @see javax.swing.JLabel#setLabelFor(java.awt.Component)
     */
    public JLabel append(String textWithMnemonic, Component c, boolean nextLine) {

        JLabel label = append(textWithMnemonic, c);
        if (nextLine) {
            nextLine();
        }
        return label;
    }


    /**
     * Adds a text label and component to the panel; the component will span
     * the specified number columns. Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the given component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @param c                the component to add
     * @param columnSpan       number of columns the component shall span
     * @return the added label
     * @see javax.swing.JLabel#setLabelFor(java.awt.Component)
     */
    public JLabel append(String textWithMnemonic, Component c, int columnSpan) {

        JLabel label = append(textWithMnemonic);
        label.setLabelFor(c);

        append(c, columnSpan);
        label.setFont(font);
        return label;
    }


    /**
     * Adds a text label and two components to the panel; each component
     * will span a single column. Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @param c1               the first component to add
     * @param c2               the second component to add
     * @return the added label
     */
    public JLabel append(String textWithMnemonic, Component c1, Component c2) {

        JLabel label = append(textWithMnemonic, c1);
        append(c2);
        return label;
    }


    /**
     * Adds a text label and two components to the panel; each component
     * will span a single column. Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @param c1               the first component to add
     * @param c2               the second component to add
     * @param colSpan          the column span for the second component
     * @return the created label
     */
    public JLabel append(String textWithMnemonic, Component c1, Component c2, int colSpan) {

        JLabel label = append(textWithMnemonic, c1);
        append(c2, colSpan);
        return label;
    }


    /**
     * Adds a text label and three components to the panel; each component
     * will span a single column. Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @param c1               the first component to add
     * @param c2               the second component to add
     * @param c3               the third component to add
     * @return the added label
     */
    public JLabel append(String textWithMnemonic, Component c1, Component c2, Component c3) {

        JLabel label = append(textWithMnemonic, c1, c2);
        append(c3);
        return label;
    }


    /**
     * Adds a text label and four components to the panel; each component
     * will span a single column. Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @param c1               the first component to add
     * @param c2               the second component to add
     * @param c3               the third component to add
     * @param c4               the fourth component to add
     * @return the added label
     */
    public JLabel append(String textWithMnemonic, Component c1, Component c2, Component c3, Component c4) {

        JLabel label = append(textWithMnemonic, c1, c2, c3);
        append(c4);
        return label;
    }


    // Appending internationalized labels with optional components ------------

    /**
     * Adds an internationalized (i15d) text label to the panel using
     * the given resource key and proceeds to the next column.
     *
     * @param resourceKey the resource key for the the label's text
     * @return the added label
     */
    public JLabel appendI15d(String resourceKey) {

        return append(getResourceString(resourceKey));
    }


    /**
     * Adds an internationalized (i15d) text label and component
     * to the panel. Then proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the given component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param resourceKey the resource key for the text to add
     * @param component   the component to add
     * @return the added label
     */
    public JLabel appendI15d(String resourceKey, Component component) {

        return append(getResourceString(resourceKey), component, 1);
    }


    /**
     * Adds an internationalized (i15d) text label and component
     * to the panel. Then proceeds to the next data column.
     * Goes to the next line if the boolean flag is set.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param resourceKey the resource key for the text to add
     * @param component   the component to add
     * @param nextLine    true forces a next line
     * @return the added label
     */
    public JLabel appendI15d(String resourceKey, Component component, boolean nextLine) {

        return append(getResourceString(resourceKey), component, nextLine);
    }


    /**
     * Adds an internationalized (i15d) text label to the panel using
     * the given resource key; then proceeds to the next data column
     * and adds a component with the given column span.
     * Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param resourceKey the resource key for the text to add
     * @param c           the component to add
     * @param columnSpan  number of columns the component shall span
     * @return the added label
     */
    public JLabel appendI15d(String resourceKey, Component c, int columnSpan) {

        return append(getResourceString(resourceKey), c, columnSpan);
    }


    /**
     * Adds an internationalized (i15d) text label and two components
     * to the panel; each component will span a single column.
     * Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param resourceKey the resource key for the text to add
     * @param c1          the first component to add
     * @param c2          the second component to add
     * @return the added label
     */
    public JLabel appendI15d(String resourceKey, Component c1, Component c2) {

        return append(getResourceString(resourceKey), c1, c2);
    }


    /**
     * Adds an internationalized (i15d) text label and two components
     * to the panel; each component will span a single column.
     * Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param resourceKey the resource key for the text to add
     * @param c1          the first component to add
     * @param c2          the second component to add
     * @param colSpan     the column span for the second component
     * @return the added label
     */
    public JLabel appendI15d(String resourceKey, Component c1, Component c2, int colSpan) {

        return append(getResourceString(resourceKey), c1, c2, colSpan);
    }


    /**
     * Adds an internationalized (i15d) text label and three components
     * to the panel; each component will span a single column.
     * Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param resourceKey the resource key for the text to add
     * @param c1          the first component to add
     * @param c2          the second component to add
     * @param c3          the third component to add
     * @return the added label
     */
    public JLabel appendI15d(String resourceKey, Component c1, Component c2, Component c3) {

        return append(getResourceString(resourceKey), c1, c2, c3);
    }


    /**
     * Adds an internationalized (i15d) text label and four components
     * to the panel; each component will span a single column.
     * Proceeds to the next data column.<p>
     * <p/>
     * The created label is labeling the first component; so the component
     * gets the focus if the (optional) label mnemonic is pressed.
     *
     * @param resourceKey the resource key for the text to add
     * @param c1          the first component to add
     * @param c2          the second component to add
     * @param c3          the third component to add
     * @param c4          the third component to add
     * @return the added label
     */
    public JLabel appendI15d(String resourceKey, Component c1, Component c2, Component c3, Component c4) {

        return append(getResourceString(resourceKey), c1, c2, c3, c4);
    }


    // Adding Titles ----------------------------------------------------------

    /**
     * Adds a title label to the panel and proceeds to the next column.
     *
     * @param textWithMnemonic the label's text - may mark a mnemonic
     * @return the added title label
     */
    public JLabel appendTitle(String textWithMnemonic) {

        JLabel titleLabel = getComponentFactory().createTitle(textWithMnemonic);
        append(titleLabel);
        return titleLabel;
    }


    /**
     * Adds an internationalized title label to the panel and
     * proceeds to the next column.
     *
     * @param resourceKey the resource key for the title's text
     * @return the added title label
     */
    public JLabel appendI15dTitle(String resourceKey) {

        return appendTitle(getResourceString(resourceKey));
    }


    // Appending Separators ---------------------------------------------------

    /**
     * Adds a separator without text that spans all columns.
     *
     * @return the added titled separator
     */
    public JComponent appendSeparator() {

        return appendSeparator("");
    }


    /**
     * Adds a separator with the given text that spans all columns.
     *
     * @param text the separator title text
     * @return the added titled separator
     */
    public JComponent appendSeparator(String text) {

        ensureCursorColumnInGrid();
        ensureHasGapRow(paragraphGapSpec);
        ensureHasComponentLine();

        setColumn(super.getLeadingColumn());
        int columnSpan = getColumnCount();
        setColumnSpan(getColumnCount());
        JComponent titledSeparator = addSeparator(text);
        setColumnSpan(1);
        nextColumn(columnSpan);
        return titledSeparator;
    }


    /**
     * Appends an internationalized titled separator for
     * the given resource key that spans all columns.
     *
     * @param resourceKey the resource key for the separator title's text
     * @return the added titled separator
     */
    public JComponent appendI15dSeparator(String resourceKey) {

        return appendSeparator(getResourceString(resourceKey));
    }


    // Overriding Superclass Behavior ***************************************

    /**
     * Returns the leading column. Unlike the superclass this method
     * honors the column offset.
     *
     * @return the leading column
     */
    @Override
    protected int getLeadingColumn() {

        int column = super.getLeadingColumn();
        return column + leadingColumnOffset * getColumnIncrementSign();
    }


    // Adding Rows **********************************************************

    /**
     * Ensures that the cursor is in the grid. In case it's beyond the
     * form's right hand side, the cursor is moved to the leading column
     * of the next line.
     */
    private void ensureCursorColumnInGrid() {

        if (isLeftToRight() && getColumn() > getColumnCount()
                || !isLeftToRight() && getColumn() < 1) {
            nextLine();
        }
    }


    /**
     * Ensures that we have a gap row before the next component row.
     * Checks if the current row is the given {@code RowSpec}
     * and appends this row spec if necessary.
     *
     * @param gapRowSpec the row specification to check for
     */
    private void ensureHasGapRow(RowSpec gapRowSpec) {

        if (getRow() == 1 || getRow() <= getRowCount()) {
            return;
        }

        if (getRow() <= getRowCount()) {
            RowSpec rowSpec = getCursorRowSpec();
            if (rowSpec == gapRowSpec) {
                return;
            }
        }
        appendRow(gapRowSpec);
        nextLine();
    }


    /**
     * Ensures that the form has a component row. Adds a component row
     * if the cursor is beyond the form's bottom.
     */
    private void ensureHasComponentLine() {

        if (getRow() <= getRowCount()) {
            return;
        }
        appendRow(defaultRowSpec);
        if (rowGroupingEnabled) {
            getLayout().addGroupedRow(getRow());
        }
    }


    /**
     * Looks up and returns the row specification of the current row.
     *
     * @return the row specification of the current row
     */
    private RowSpec getCursorRowSpec() {

        return getLayout().getRowSpec(getRow());
    }


}

