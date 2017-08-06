package ofedorova;

/**
 * Class implement engineering calculator.
 * @author Olga Fedorova
 * @since 22.09.2016
 * @version 1
 */
public class EngineeringCalc extends InteractCalc{
    
    /**
    * The class returns the trigonometric sine of an angle.
    * @author Olga Fedorova
    * @since 22.09.2016
    * @version 1
    */
    private class SinAction extends InteractCalc.Action{

        /**
         * Allocates a new {@code SinAction}
         * @param key
         * @param name 
         */
        public SinAction() {
            super("sin", "the trigonometric sine of an angl");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            EngineeringCalc.this.setResult(Math.sin(EngineeringCalc.this.getOperand()));
            EngineeringCalc.this.showResult();
        }
        
    }
    
    /**
    * The class returns the trigonometric cosine of an angle.
    * @author Olga Fedorova
    * @since 22.09.2016
    * @version 1
    */
    private class CosAction extends InteractCalc.Action{

        /**
         * Allocates a new {@code CosAction}
         * @param key
         * @param name 
         */
        public CosAction() {
            super("cos", "the trigonometric cosine of an angle");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            EngineeringCalc.this.setResult(Math.cos(EngineeringCalc.this.getOperand()));
            EngineeringCalc.this.showResult();
        }
        
    }
    
    /**
    * The class returns the trigonometric tangent of an angle.
    * @author Olga Fedorova
    * @since 22.09.2016
    * @version 1
    */
    private class TgAction extends InteractCalc.Action{

        /**
         * Allocates a new {@code TgAction}
         * @param key
         * @param name 
         */
        public TgAction() {
            super("tg", "the trigonometric tangent of an angle");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            EngineeringCalc.this.setResult(Math.tan(EngineeringCalc.this.getOperand()));
            EngineeringCalc.this.showResult();
        }
        
    }
    
    /**
    * The class returns the trigonometric cotangent of an angle..
    * @author Olga Fedorova
    * @since 22.09.2016
    * @version 1
    */
    private class CtgAction extends InteractCalc.Action{

        /**
         * Allocates a new {@code CtgAction}
         * @param key
         * @param name 
         */
        public CtgAction() {
            super("ctg", "the trigonometric cotangent of an angle");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            EngineeringCalc.this.setResult(Math.cos(EngineeringCalc.this.getOperand()) / Math.sin(EngineeringCalc.this.getOperand()));
            EngineeringCalc.this.showResult();
        }
    }

    /**
    * The method fills the array "actions".
    */
    @Override
    public void fillAction() {
        super.fillAction(); 
        this.addAction(new SinAction());
        this.addAction(new CosAction());
        this.addAction(new TgAction());
        this.addAction(new CtgAction());
    }
    
    public static void main(String[] args) {
        new EngineeringCalc().init();
    }

}
