import FormLayout from "../components/Layout/FormLayout";
import MessageSender from "../components/Webhook/MessageSender";

const Webhook = () => {
  return (
    <FormLayout>
      <MessageSender />
    </FormLayout>
  );
};

export default Webhook;
